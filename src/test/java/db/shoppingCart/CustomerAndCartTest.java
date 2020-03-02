package db.shoppingCart;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

class CustomerAndCartTest {

    private EntityManager entityManager;

    @BeforeEach
    void setup() throws Exception  {
        entityManager = Persistence.createEntityManagerFactory("test")
                .createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.createQuery("DELETE FROM Customer");
        transaction.commit();
    }

    @DisplayName(
            "given customer login 'Mike' with name 'Smith'" +
                    "when create" +
                    "then customer with given login and id can be found"
    )
    @Test
    void create() throws Exception  {
        //given
        CustomerCrudeService customerCrudeService =
                new JpaCustomerCrudeService(entityManager);
        String name = "Smith";
        String login = "Mike";

        //when
        Customer newCustomer = customerCrudeService.create(name, login);

        //then
        Customer foundCustomer = customerCrudeService.find(newCustomer.getId()).get();
        assertThat(foundCustomer.getName()).isEqualTo(name);
        assertThat(foundCustomer.getLogin()).isEqualTo(login);
    }

    @DisplayName(
            "given customer with login 'Mike' with name 'Smith'" +
                    "when update old login with new login 'Tommy'" +
                    "then old login is updated"
    )
    @Test
    void update() throws Exception {
        //given
        CustomerCrudeService customerCrudeService =
                new JpaCustomerCrudeService(entityManager);
        String name = "Smith";
        String login = "Mike";
        Customer oldCustomer = customerCrudeService.create(name, login);
        Customer newCustomer = new Customer("Smith", "Tommy");
        newCustomer.setId(oldCustomer.getId());

        //when
        customerCrudeService.update(newCustomer);

        //then
        Customer foundCustomer = customerCrudeService.find(oldCustomer.getId()).get();
        assertThat(foundCustomer.getLogin()).isEqualTo("Tommy");
        assertThat(foundCustomer.getName()).isEqualTo("Smith");
    }

    @DisplayName("given customer with shopping cart" +
            "and shopping cart " +
            "when updating customer with this cart" +
            "then this cart is added to customer")
    @Test
    void addingShoppingCart() throws Exception  {
        //given
        CustomerCrudeService customerCrudeService = new JpaCustomerCrudeService(entityManager);
        String name = "Smith";
        String login = "Tom";
        Customer oldCustomer = customerCrudeService.create(name, login);
        Product ham;
        Product cheese;
        Collection<Product> products = Arrays.asList( ham = new Product ("ham", 10.00),
                cheese = new Product("cheese", 8.0));
        Cart firstCart = new Cart(1, products);
        Customer customerWithCart = new Customer(name, login);
        customerWithCart.setId(oldCustomer.getId());
        customerWithCart.getCarts().add(firstCart);
        //when
        customerCrudeService.update(customerWithCart);
        //then
        Customer foundCustomer = customerCrudeService.find(oldCustomer.getId()).get();
        assertThat(foundCustomer.getCarts())
                .extracting("orderNumber")
                .containsExactlyInAnyOrder(1);
        assertThat(foundCustomer.getCarts().stream()
                .flatMap(cart -> cart.getProducts().stream().map(Product::getProductName))
                .equals(products.stream().map(Product::getProductName)));
    }


    @DisplayName("given Customer with shopping cart" +
            "when delete customer" +
            "then customer is deleted")

    @Test
    void deleteCustomer()throws Exception {
        //given
        CustomerCrudeService customerCrudeService = new JpaCustomerCrudeService(entityManager);
        String name = "Smith";
        String login = "Tom";
        Collection<Product> products = Arrays.asList(
                new Product("ham", 10.00),
                new Product("cheese", 15.00)
        );
        Cart cart = new Cart(1, products);
        Customer myCustomer = customerCrudeService.create(name, login);
        myCustomer.getCarts().add(cart);
        //when
        customerCrudeService.delete(myCustomer.getId());
        //then

        assertThat(customerCrudeService.find(myCustomer.getId())).isEmpty();
    }
}
package db.shoppingCart;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Optional;
import java.util.UUID;

public class JpaCustomerCrudeService implements CustomerCrudeService {

    private EntityManager entityManager;

    public JpaCustomerCrudeService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Customer create(String name, String login) {
        Customer customer = new Customer(name, login);
        runInTransaction(() -> entityManager.persist(customer));
        return customer;
    }

    @Override
    public void update(Customer newCustomer) {
        runInTransaction(() -> entityManager.merge(newCustomer));
    }

    @Override
    public Optional<Customer> find(UUID id) {
        return Optional.ofNullable(entityManager.find(Customer.class, id));
    }

    @Override
    public void delete(UUID id) {
        runInTransaction(() -> {
            Customer customer = entityManager.find(Customer.class, id);
            entityManager.remove(customer);
        });
    }

    private void runInTransaction(Runnable runnable) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            runnable.run();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }
}

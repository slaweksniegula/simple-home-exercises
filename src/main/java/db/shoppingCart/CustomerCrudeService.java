package db.shoppingCart;

import java.util.Optional;
import java.util.UUID;

public interface CustomerCrudeService {

    Customer create(String name, String login);

    void update (Customer newCustomer);

    Optional<Customer> find (UUID id);

    void delete (UUID id);
}

package db.shoppingCart;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String login;

    @OneToMany (cascade = CascadeType.MERGE)
    @JoinColumn (name = "fc_customer")
    Collection <Cart> carts = new ArrayList<>();


    public Customer(String name, String login) {
        this.name = name;
        this.login = login;
    }
}

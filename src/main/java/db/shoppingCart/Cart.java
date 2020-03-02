package db.shoppingCart;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

@Data
@NoArgsConstructor

@Entity

public class Cart {
    @Id
    @GeneratedValue

    private UUID id;
    private int orderNumber;
    private double totalPrice = 0.00;

    @OneToMany (cascade = CascadeType.MERGE)
    @JoinColumn (name = "fk_cart")

    private Collection<Product> products = new ArrayList<>();

    public Cart(int orderNumber, Collection products) {
        this.orderNumber = orderNumber;
    }

}

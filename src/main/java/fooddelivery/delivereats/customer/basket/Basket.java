package fooddelivery.delivereats.customer.basket;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String foodItem;

    private int quantity;

    private double price;

    public Basket(String foodItem, int quantity, double price) {
        this.foodItem = foodItem;
        this.quantity = quantity;
        this.price = price;
    }
}




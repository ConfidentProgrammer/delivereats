package fooddelivery.delivereats.restaurant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table
public class Menu {
//    @Id
//    @SequenceGenerator(
//            name="Menu_Sequence",
//            sequenceName = "Menu_Sequence",
//            allocationSize = 1
//    )
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "Menu_Sequence"
//    )

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    private Double price;

//    @ManyToOne(cascade = {CascadeType.ALL})
//    @JoinColumn(name = "menu_id")
//    private Restaurant restaurant;

    public Menu(String name, Double price) {
        this.name = name;
        this.price = price;
    }

//    public Menu(String name, Double price, Restaurant restaurant) {
//        this.name = name;
//        this.price = price;
//        this.restaurant = restaurant;
//    }
}

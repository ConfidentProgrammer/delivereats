package fooddelivery.delivereats.restaurant;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table

public class Restaurant {

//    @Id
//    @SequenceGenerator(
//            name="restaurant_sequence",
//            sequenceName = "restaurant_sequence",
//            allocationSize = 1
//    )
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "restaurant_sequence"
//    )
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String restaurantName;

    private String address;
    private double longitude;

    private double latitude;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "restaurant_id")
    //@ElementCollection
    private List<Menu> menu;

    public Restaurant(String restaurantName, String address, double longitude, double latitude, List<Menu> menu) {
        this.restaurantName = restaurantName;
        this.address = address;
        this.longitude = longitude;
        this.latitude = latitude;
        this.menu = menu;
    }
}

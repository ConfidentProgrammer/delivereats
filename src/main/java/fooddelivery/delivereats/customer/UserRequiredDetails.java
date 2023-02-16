package fooddelivery.delivereats.customer;

import fooddelivery.delivereats.customer.basket.Basket;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRequiredDetails {
    private String firstName;
    private String lastName;
    private String email;

    private String address;
    private double longitude;
    private double latitude;

    private List<Basket> basket;
}

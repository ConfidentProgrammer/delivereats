package fooddelivery.delivereats.restaurant;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@AllArgsConstructor
@RestController
@RequestMapping(path = "api/restaurant")
public class RestaurantController {
    private final RestaurantService restaurantService;
    @GetMapping
    public List<Restaurant> getRestaurant() {
        return restaurantService.getRestaurants();
    }

    @PostMapping
    public void postRestaurants(@RequestBody Restaurant[] restaurants) {
        restaurantService.postRestaurant(restaurants);
    }
}

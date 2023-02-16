package fooddelivery.delivereats.restaurant;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class RestaurantService {
    private final RestaurantRepository repository;
    public List<Restaurant> getRestaurants() {
       return  repository.findAll();
    }


    public void postRestaurant(Restaurant[] restaurants) {

        repository.saveAll(List.of(restaurants));


    }
}

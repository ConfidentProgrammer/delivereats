package fooddelivery.delivereats.customer;

import fooddelivery.delivereats.customer.basket.Basket;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/userdetails")
public class AppUserController {

    private final AppUserService appUserService;
    @GetMapping
    public UserRequiredDetails getAppUser(){
        return appUserService.getAppUser();
    }

    @PutMapping(path = "/updatebasket")
    public void updateBasket(
            @RequestBody(required = false) Basket[] basket
    ) {

        appUserService.updateBasket(basket);
    }

    @GetMapping(path = "/bill")
    public double getBill(){
        return appUserService.calculateBill();
    }
}

package fooddelivery.delivereats.registration;

import fooddelivery.delivereats.customer.AppUser;
import fooddelivery.delivereats.customer.AppUserRole;
import fooddelivery.delivereats.customer.AppUserService;
import fooddelivery.delivereats.customer.basket.Basket;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class RegistrationService {
    private final AppUserService appUserService;
    public String register(RegistrationRequest request) {

         double startLat =  43;
         double  startLong = -78;
        double random = new Random().nextDouble();
        double longi = startLong + (random * 2);
        double lat = startLat + (random * 2);


        return appUserService.signUpUser(new AppUser(
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                request.getPassword(),request.getAddress(),longi, lat,
                AppUserRole.USER, List.of()
        ));
    }
}

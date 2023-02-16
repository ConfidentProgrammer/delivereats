package fooddelivery.delivereats.customer;

import fooddelivery.delivereats.customer.basket.Basket;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {
    private final AppUserRepository appUserRepository;
    //private final BasketRepository basketRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException("UserName not found "+email));
    }

    public String signUpUser(AppUser appUser){
        boolean userExists = appUserRepository.findByEmail(appUser.getEmail()).isPresent();
        if(userExists){
            throw new IllegalStateException("Email Already Taken");
        }

       // if user does not exist then encode the password and
        String encodedPassword = bCryptPasswordEncoder.encode(appUser.getPassword());
        appUser.setPassword(encodedPassword);
        appUserRepository.save(appUser);

        return "Sign Up Successful for username "+appUser.getEmail();
    }

    public Optional<AppUser> getAllDetailsOfAppUser() {
        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = user.getUsername();
        Optional<AppUser> customer = appUserRepository.findByEmail(username);
        return customer;
    }

    public UserRequiredDetails getAppUser() {
        Optional<AppUser> allDetails = getAllDetailsOfAppUser();
        AppUser user = allDetails.get();
        UserRequiredDetails customer = new UserRequiredDetails(user.getFirstName(), user.getLastName(),user.getEmail(),
                user.getAddress(), user.getLongitude(), user.getLatitude(), user.getBasket());

       //System.out.println(user.getBasket());
        return customer;

    }

    @Transactional
    public void updateBasket(Basket[] basket) {
        //getting the id
        Optional<AppUser> allDetails = getAllDetailsOfAppUser();
        AppUser user = allDetails.get();

        try {
            if(basket.length>0){
                user.setBasket(List.of(basket));
            }
        }catch (Exception e) {
          throw new IllegalStateException("Cannot add to the basket due to"+ e.getMessage());
        }
    }


    public double calculateBill() {
        Optional<AppUser> allDetails = getAllDetailsOfAppUser();
        AppUser user = allDetails.get();
        List<Basket> basket = user.getBasket();
        double total = 0;
        for(Basket b : basket) {
            total+=b.getPrice()*b.getQuantity();
        }

        return total;
    }
}

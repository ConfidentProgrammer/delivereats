package fooddelivery.delivereats.registration;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {



    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;

    private final String address;

    private final double longitude ;
    private final double latitude;


}

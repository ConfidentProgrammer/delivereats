package fooddelivery.delivereats.customer.basket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BasketRepository extends JpaRepository<Basket, Long> {

//    @Query("select b from Basket b where b.app_user_id = ?1")
//    List<Basket> findBasketByUserid(long userid);
}

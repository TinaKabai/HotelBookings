package za.ac.cput.Repository.payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Domain.Payment.CreditCard;

import java.util.Map;
import java.util.Set;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, String> {

    //Map<CreditCard, CreditCard> getAll();
}

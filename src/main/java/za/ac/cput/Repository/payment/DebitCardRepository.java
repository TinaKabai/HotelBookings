package za.ac.cput.Repository.payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Domain.Payment.DebitCard;

import java.util.Map;
import java.util.Set;

@Repository
public interface DebitCardRepository extends JpaRepository<DebitCard, String> {

    //Map<DebitCard, DebitCard> getAll();
}

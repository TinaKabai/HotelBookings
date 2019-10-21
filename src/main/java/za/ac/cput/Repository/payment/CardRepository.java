package za.ac.cput.Repository.payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Domain.Payment.Card;

import java.util.Map;

@Repository
public interface CardRepository extends JpaRepository<Card, String> {

    //Map<Card, Card> getAll();
}

package za.ac.cput.Repository.payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Domain.Payment.Cash;

import java.util.Map;

@Repository
public interface CashRepository extends JpaRepository<Cash, String> {

    //Map<Cash, Cash> getAll();
}

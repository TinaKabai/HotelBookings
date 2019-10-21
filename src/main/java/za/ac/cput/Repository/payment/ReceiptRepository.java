package za.ac.cput.Repository.payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Domain.Payment.Receipt;

import java.util.Set;

@Repository
public interface ReceiptRepository extends JpaRepository<Receipt, String> {

    //Set<Receipt> getAll();
}

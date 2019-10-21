package za.ac.cput.Repository.content;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Domain.Content.Booking;

import java.util.Map;

@Repository
public interface BookingRepository extends JpaRepository<Booking, String> {

   // Map<Booking, Booking> getAll();
}

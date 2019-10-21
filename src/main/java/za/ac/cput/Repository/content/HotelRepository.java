package za.ac.cput.Repository.content;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Domain.Content.Hotel;

import java.util.Set;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, String> {

   // Set<Hotel> getAll();
}

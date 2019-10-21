package za.ac.cput.Repository.content;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Domain.Content.Deluxe;

import java.util.Map;

@Repository
public interface DeluxeRepository extends JpaRepository<Deluxe, String> {

    //Map<Deluxe, Deluxe> getAll();
}

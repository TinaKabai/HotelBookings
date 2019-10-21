package za.ac.cput.Repository.content;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Domain.Content.Guest;

import java.util.Map;

@Repository
public interface GuestRepository extends JpaRepository<Guest, String> {

    //Map<Guest, Guest> getAll();
}

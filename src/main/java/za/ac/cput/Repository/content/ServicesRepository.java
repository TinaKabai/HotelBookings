package za.ac.cput.Repository.content;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Domain.Content.Services;

import java.util.Set;

@Repository
public interface ServicesRepository extends JpaRepository<Services, String> {

    //Set<Services> getAll();
}

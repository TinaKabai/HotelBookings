package za.ac.cput.Repository.content;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Domain.Content.NonAC;

import java.util.Set;

@Repository
public interface NonACRepository extends JpaRepository<NonAC, String> {

    //Set<NonAC> getAll();
}

package za.ac.cput.Repository.content;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Domain.Content.Suite;

import java.util.Set;

@Repository
public interface SuiteRepository extends JpaRepository<Suite, String> {

    //Set<Suite> getAll();
}

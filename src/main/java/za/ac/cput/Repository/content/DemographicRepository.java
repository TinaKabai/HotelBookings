package za.ac.cput.Repository.content;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Domain.Content.Demographic;

import java.util.Map;

@Repository
public interface DemographicRepository extends JpaRepository<Demographic, String> {

    //Map<Demographic, Demographic> getAll();
}

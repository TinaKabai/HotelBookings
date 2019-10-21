package za.ac.cput.Repository.activities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Domain.Activites.Sport;

import java.util.Set;

@Repository
public interface SportRepository extends JpaRepository<Sport, String> {

   // Set<Sport> getAll();
}

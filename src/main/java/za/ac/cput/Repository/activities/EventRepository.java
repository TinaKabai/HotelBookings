package za.ac.cput.Repository.activities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Domain.Activites.Event;

import java.util.Map;

@Repository
public interface EventRepository extends JpaRepository<Event, String> {

    //Map<Event, Event> getAll();
}

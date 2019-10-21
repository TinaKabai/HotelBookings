package za.ac.cput.Repository.content;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Domain.Content.Room;

import java.util.Set;

@Repository
public interface RoomRepository extends JpaRepository<Room, String> {

    //Set<Room> getAll();
}

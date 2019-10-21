package za.ac.cput.Repository.tour;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Domain.Tour.Groups;

import java.util.Map;
import java.util.Set;

@Repository
public interface GroupsRepository extends JpaRepository<Groups, String> {

    //Map<Groups, Groups> getAll();
}

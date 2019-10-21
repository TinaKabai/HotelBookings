package za.ac.cput.Repository.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Domain.Users.Register;

import java.util.Set;

@Repository
public interface RegisterRepository extends JpaRepository<Register, String> {

    //Set<Register> getAll();
}

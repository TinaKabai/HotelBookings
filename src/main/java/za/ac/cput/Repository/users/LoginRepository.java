package za.ac.cput.Repository.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Domain.Users.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, String> {

    //Set<Login> getAll();

}

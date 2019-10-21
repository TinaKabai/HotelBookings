package za.ac.cput.Repository.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Domain.Users.Admin;

@Repository
 public interface AdminRepository extends JpaRepository<Admin, String> {

        //Admin save(Admin admin);
        // Map<Admin, Admin> getAll();
}

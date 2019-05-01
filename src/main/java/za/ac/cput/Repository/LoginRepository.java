package za.ac.cput.Repository;

import za.ac.cput.Domain.Users.Login;

import java.util.Set;

public interface LoginRepository extends IRepository<Login, String> {

    Set<Login> getAll();
}

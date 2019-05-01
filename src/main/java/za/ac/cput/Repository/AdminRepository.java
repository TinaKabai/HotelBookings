package za.ac.cput.Repository;

import za.ac.cput.Domain.Users.Admin;

import java.util.Set;

public interface AdminRepository extends IRepository<Admin, String> {

    Set<Admin> getAll();
}

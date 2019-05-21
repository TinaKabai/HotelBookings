package za.ac.cput.Repository;

import za.ac.cput.Domain.Users.Admin;

import java.util.Map;

public interface AdminRepository extends IRepository<Admin, String> {

    Map<Admin, Admin> getAll();
}

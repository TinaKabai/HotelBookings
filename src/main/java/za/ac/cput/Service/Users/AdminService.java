package za.ac.cput.Service.Users;

import za.ac.cput.Domain.Users.Admin;
import za.ac.cput.Service.GenIService;

import java.util.Set;
import java.util.List;

public interface AdminService extends GenIService<Admin, String> {

    Admin retrieveById(String id);
    List<Admin> getAll();
}
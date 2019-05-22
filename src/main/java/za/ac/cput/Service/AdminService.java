package za.ac.cput.Service;

import za.ac.cput.Domain.Users.Admin;

import java.util.Map;

public interface AdminService extends IService<Admin, String> {

    Map<Admin, Admin> getAll();
}

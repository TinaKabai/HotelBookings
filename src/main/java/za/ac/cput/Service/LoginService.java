package za.ac.cput.Service;

import za.ac.cput.Domain.Users.Login;

import java.util.Set;

public interface LoginService extends IService<Login, String> {

    Set<Login> getAll();
}

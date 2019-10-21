package za.ac.cput.Service.Users;

import za.ac.cput.Domain.Users.Login;
import za.ac.cput.Service.GenIService;

import java.util.List;
import java.util.Set;

public interface LoginService extends GenIService<Login, String> {

    Login retrieveById(String id);
    List<Login> getAll();
}

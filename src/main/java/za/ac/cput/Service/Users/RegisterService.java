package za.ac.cput.Service.Users;

import za.ac.cput.Domain.Users.Register;
import za.ac.cput.Service.GenIService;

import java.util.List;
import java.util.Set;

public interface RegisterService extends GenIService<Register, String> {

    Register retrieveById(String id);
    List<Register> getAll();
}

package za.ac.cput.Service;

import za.ac.cput.Domain.Users.Register;

import java.util.Set;

public interface RegisterService extends IService<Register, String> {

    Set<Register> getAll();
}

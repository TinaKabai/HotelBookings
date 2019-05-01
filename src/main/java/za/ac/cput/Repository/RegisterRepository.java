package za.ac.cput.Repository;

import za.ac.cput.Domain.Users.Register;

import java.util.Set;

public interface RegisterRepository extends IRepository<Register, String> {

    Set<Register> getAll();
}

package za.ac.cput.Repository.Implementation;

import za.ac.cput.Domain.Users.Register;
import za.ac.cput.Repository.RegisterRepository;

import java.util.HashSet;
import java.util.Set;

public class RegisterRepositoryImpl implements RegisterRepository {

    private static RegisterRepositoryImpl repository = null;
    private Set<Register> registers;

    private RegisterRepositoryImpl() {
        this.registers = new HashSet<Register>();
    }

    public static RegisterRepositoryImpl getRepository() {
        if (repository == null) repository = new RegisterRepositoryImpl();
        return repository;
    }

    public Register create(Register register) {
        this.registers.add(register);
        return register;
    }

    public Register read(String fisrtName) {
        // find the course that matches the id and return it if exist
        return null;
    }

    public void delete(String fisrtName) {
        // find the course, delete it if it exist
    }

    public Register update(Register register) {
        // find the course, update it and delete it if it exists
        return register;
    }

    public Set<Register> getAll(){
        return this.registers;
    }
}

package za.ac.cput.Repository.Implementation;

import za.ac.cput.Domain.Users.Register;
import za.ac.cput.Repository.RegisterRepository;

import java.util.HashSet;
import java.util.Set;

public class RegisterRepositoryImpl implements RegisterRepository {

    private static RegisterRepositoryImpl repository = null;
    private Set<Register> registers;

    private RegisterRepositoryImpl() {
        this.registers = new HashSet<>();
    }

    private Register registration(String firstname) {
        return this.registers.stream()
                .filter(register -> register.getFisrtName().trim().equals(firstname))
                .findAny()
                .orElse(null);
    }

    public static RegisterRepositoryImpl getRepository() {
        if (repository == null) repository = new RegisterRepositoryImpl();
        return repository;
    }

    public Register create(Register register) {
        this.registers.add(register);
        return register;
    }

    public Register read(final String firstname){
        Register register = registration(firstname);
        return register;
    }

    public void delete(String firstname) {
        Register register = registration(firstname);
        if (register != null) this.registers.remove(register);
    }

    public Register update(Register register){
        Register toDelete = registration(register.getFisrtName());
        if(toDelete != null) {
            this.registers.remove(toDelete);
            return create(register);
        }
        return null;
    }

    public Set<Register> getAll(){
        return this.registers;
    }
}

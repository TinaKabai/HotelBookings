package za.ac.cput.Repository.Implementation;

import za.ac.cput.Domain.Users.Login;
import za.ac.cput.Repository.LoginRepository;

import java.util.HashSet;
import java.util.Set;

public class LoginRepositoryImpl implements LoginRepository {

    private static LoginRepositoryImpl repository = null;
    private Set<Login> logins;

    private LoginRepositoryImpl() {
        this.logins = new HashSet<Login>();
    }

    public static LoginRepositoryImpl getRepository() {
        if (repository == null) repository = new LoginRepositoryImpl();
        return repository;
    }

    public Login create(Login login) {
        this.logins.add(login);
        return login;
    }

    public Login read(String username) {
        // find the course that matches the id and return it if exist
        return null;
    }

    public void delete(String username) {
        // find the course, delete it if it exist
    }

    public Login update(Login login) {
        // find the course, update it and delete it if it exists
        return login;
    }

    public Set<Login> getAll(){
        return this.logins;
    }
}

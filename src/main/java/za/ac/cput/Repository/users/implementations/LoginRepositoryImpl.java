/*package za.ac.cput.Repository.Implementation;

import org.springframework.stereotype.Repository;
import za.ac.cput.Domain.Users.Login;
import za.ac.cput.Repository.users.LoginRepository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class LoginRepositoryImpl implements LoginRepository {

    private static LoginRepositoryImpl repository = null;
    private Set<Login> logins;

    private LoginRepositoryImpl() {
        this.logins = new HashSet<Login>();
    }

    private Login logsIn(String username) {
        return this.logins.stream()
                .filter(login -> login.getUsername().trim().equals(username))
                .findAny()
                .orElse(null);
    }

    public static LoginRepositoryImpl getRepository() {
        if (repository == null) repository = new LoginRepositoryImpl();
        return repository;
    }

    public Login create(Login login) {
        this.logins.add(login);
        return login;
    }

    public Login read(final String username){
        Login login = logsIn(username);
        return login;
    }

    public void delete(String username) {
        Login login = logsIn(username);
        if (login != null) this.logins.remove(login);
    }

    public Login update(Login login){
        Login toDelete = logsIn(login.getUsername());
        if(toDelete != null) {
            this.logins.remove(toDelete);
            return create(login);
        }
        return null;
    }

    public Set<Login> getAll(){
        return this.logins;
    }
}*/

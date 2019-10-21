package za.ac.cput.Service.Users.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Domain.Users.Login;
import za.ac.cput.Repository.users.LoginRepository;
import za.ac.cput.Service.Users.LoginService;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    private static LoginService service = null;

    @Autowired
    private LoginRepository repo;

    private LoginServiceImpl(){

    }

    public static LoginService getService()
    {
        if(service == null) service = new LoginServiceImpl();
        return service;
    }

    @Override
    public Login retrieveById(String id)
    {
        List<Login> logins = getAll();
        for(Login l: logins)
        {
            if (l.getUsername().equals(id)) return l;
        }
        return null;
    }

    @Override
    public List<Login> getAll() {
        return this.repo.findAll();
    }

    public Login create(Login login) {
        return this.repo.save(login);
    }


    public Login read(String s) {
        return this.repo.findById(s).orElse(null);
    }


    public Login update(Login login) {
        return this.repo.save(login);
    }

    @Override
    public void delete(String s) {
        this.repo.deleteById(s);
    }
}

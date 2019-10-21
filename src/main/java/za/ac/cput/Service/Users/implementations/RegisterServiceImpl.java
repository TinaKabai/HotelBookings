package za.ac.cput.Service.Users.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Domain.Users.Register;
import za.ac.cput.Repository.users.RegisterRepository;
import za.ac.cput.Service.Users.RegisterService;

import java.util.List;

@Service
public class RegisterServiceImpl implements RegisterService {

    private static RegisterService service = null;

    @Autowired
    private RegisterRepository repo;

    private RegisterServiceImpl(){

    }

    public static RegisterService getService()
    {
        if(service == null) service = new RegisterServiceImpl();
        return service;
    }

    @Override
    public Register retrieveById(String id)
    {
        List<Register> registers = getAll();
        for(Register r: registers)
        {
            if (r.getUsername().equals(id)) return r;
        }
        return null;
    }

    @Override
    public List<Register> getAll() {
        return this.repo.findAll();
    }

    public Register create(Register register) {
        return this.repo.save(register);
    }


    public Register read(String s) {
        return this.repo.findById(s).orElse(null);
    }


    public Register update(Register register) {
        return this.repo.save(register);
    }

    @Override
    public void delete(String s) {
        this.repo.deleteById(s);
    }
}

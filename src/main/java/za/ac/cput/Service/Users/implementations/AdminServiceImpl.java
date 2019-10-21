package za.ac.cput.Service.Users.implementations;

import za.ac.cput.Domain.Users.Admin;
import za.ac.cput.Repository.users.AdminRepository;
import za.ac.cput.Service.Users.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    private static AdminService service = null;

    @Autowired
    private AdminRepository repo;

    private AdminServiceImpl(){

    }

    public static AdminService getService()
    {
        if(service == null) service = new AdminServiceImpl();
        return service;
    }

    @Override
    public Admin retrieveById(String id)
    {
        List<Admin> admins = getAll();
        for(Admin a: admins)
        {
            if (a.getID().equals(id)) return a;
        }
        return null;
    }

    @Override
    public List<Admin> getAll() {
        return this.repo.findAll();
    }

    public Admin create(Admin admin) {
        return this.repo.save(admin);
    }


    public Admin read(String s) {
        return this.repo.findById(s).orElse(null);
    }


    public Admin update(Admin admin) {
        return this.repo.save(admin);
    }


    public void delete(String s) {
        this.repo.deleteById(s);
    }
}

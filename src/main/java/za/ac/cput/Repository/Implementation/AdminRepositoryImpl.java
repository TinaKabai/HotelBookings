package za.ac.cput.Repository.Implementation;

import za.ac.cput.Domain.Users.Admin;
import za.ac.cput.Repository.AdminRepository;

import java.util.HashSet;
import java.util.Set;

public class AdminRepositoryImpl implements AdminRepository {

    private static AdminRepositoryImpl repository = null;
    private Set<Admin> admins;

    private AdminRepositoryImpl() {
        this.admins = new HashSet<Admin>();
    }

    public static AdminRepositoryImpl getRepository() {
        if (repository == null) repository = new AdminRepositoryImpl();
        return repository;
    }

    public Admin create(Admin admin) {
        this.admins.add(admin);
        return admin;
    }

    public Admin read(String password) {
        // find the course that matches the id and return it if exist
        return null;
    }

    public void delete(String password) {
        // find the course, delete it if it exist
    }

    public Admin update(Admin admin) {
        // find the course, update it and delete it if it exists
        return admin;
    }

    public Set<Admin> getAll(){
        return this.admins;
    }
}

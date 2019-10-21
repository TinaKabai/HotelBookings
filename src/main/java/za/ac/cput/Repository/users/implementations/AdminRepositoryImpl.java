/*package za.ac.cput.Repository.Implementation;

import za.ac.cput.Domain.Users.Admin;
import za.ac.cput.Repository.users.LoginRepository.AdminRepository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository*/
/*public class AdminRepositoryImpl implements AdminRepository {

    private static AdminRepositoryImpl repository = null;
    private Map<Admin, Admin> admins;

    private AdminRepositoryImpl() {
        this.admins = new HashMap<>();
    }

    private Admin findAdmin(String adminId) {
        return this.admins.values().stream()
                .filter(admin -> admin.getID().trim().equals(adminId))
                .findAny()
                .orElse(null);
    }

    public static AdminRepositoryImpl getRepository() {
        if (repository == null) repository = new AdminRepositoryImpl();
        return repository;
    }

    public Admin create(Admin admin) {
        this.admins.put(admin, admin);
        return admin;
    }

    public Admin read(final String adminId){
        Admin admin = findAdmin(adminId);
        return admin;
    }

    public void delete(String adminId) {
        Admin admin = findAdmin(adminId);
        if (admin != null) this.admins.remove(admin);
    }

    public Admin update(Admin admin) {
        Admin toDelete = findAdmin(admin.getID());
        if(toDelete != null) {
            this.admins.remove(toDelete);
            return create(admin);
        }
        return null;
    }

    public Map<Admin, Admin> getAll(){
        return this.admins;
    }
}*/

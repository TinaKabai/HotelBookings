package za.ac.cput.Factory;

import za.ac.cput.Domain.Users.Admin;

public class AdminFactory {
    public static Admin adminlogin(int id, String passW){
        return new Admin.Builder().ID(id).passWord(passW).build();
    }

}

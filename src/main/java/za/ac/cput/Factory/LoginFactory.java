package za.ac.cput.Factory;

import za.ac.cput.Domain.Users.Login;

public class LoginFactory {
    public static Login login(String usernm, String passW){
        return new Login.Builder().username(usernm).password(passW).build();
    }
}

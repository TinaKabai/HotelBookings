package za.ac.cput.Factory;

import za.ac.cput.Domain.Users.Register;

public class RegisterFactory {
    public static Register registration(String fName, String lName, String DOB, String usernm, String passW, String confirm){
        return new Register.Builder().firstName(fName).lastName(lName).dob(DOB).username(usernm).password(passW).confirmedPass(confirm).build();
    }
}

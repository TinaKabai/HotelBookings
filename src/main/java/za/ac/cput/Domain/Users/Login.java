package za.ac.cput.Domain.Users;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Login {

    @Id
    private String username;
    protected String password;

    public Login() {
    }
    private Login(Builder builder){
        this.username = builder.username;
        this.password = builder.password;
    }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
public static class Builder{
    private String username;
    protected String password;

    public Builder username(String usernm){
        this.username = usernm;
        return this;
    }
    public Builder password(String pass){
        this.password = pass;
        return this;
    }
    public Login build(){
        return new Login(this);
    }

    public Builder copy(Login login) {
        this.username = login.username;
        this.password = login.password;

        return this;
    }
}
}

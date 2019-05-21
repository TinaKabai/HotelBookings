package za.ac.cput.Domain.Users;

public class Admin {
    private String ID;
    private String password;

    public Admin() {
    }
    private Admin(Builder builder){
        this.ID = builder.ID;
        this.password = builder.password;
    }

    public String getID() {
        return ID;
    }

    public String getPassword() {
        return password;
    }

public static class Builder{
    private String ID;
    private String password;

    public Builder ID(String id){
        this.ID = id;
        return this;
    }
    public Builder passWord(String password){
        this.password = password;
        return this;
    }
    public Admin build(){
        return new Admin(this);
    }
}
}

package za.ac.cput.Domain.Users;

public class Admin {
    private int ID;
    private String password;

    public Admin() {
    }
    private Admin(Builder builder){

    }
public static class Builder{
    private int ID;
    private String password;

    public Builder ID(int id){
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

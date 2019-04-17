package za.ac.cput.Domain.Users;

public class Register {
    private String fisrtName;
    private String lastName;
    private String DOB;
    protected String username;
    private String password;
    protected String confPassword;

    public Register() {
    }
    private Register(Builder builder){
        this.fisrtName = builder.fisrtName;
        this.lastName = builder.lastName;
        this.DOB = builder.DOB;
        this.username = builder.username;
        this.password = builder.password;
        this.confPassword = builder.confPassword;
    }
    public String getFisrtName() {
        return fisrtName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDOB() {
        return DOB;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getConfPassword() {
        return confPassword;
    }
public static class Builder{
    private String fisrtName;
    private String lastName;
    private String DOB;
    protected String username;
    private String password;
    protected String confPassword;

    public Builder firstName(String fisrtName){
        this.fisrtName = fisrtName;
        return this;
    }
    public Builder lastName(String lastName){
        this.lastName = lastName;
        return this;
    }
    public Builder dob(String DOB){
        this.DOB = DOB;
        return this;
    }
    public Builder username(String username){
        this.username = username;
        return this;
    }
    public Builder password(String password){
        this.password = password;
        return this;
    }
    public Builder confirmedPass(String confPassword){
        this.confPassword = confPassword;
        return this;
    }
   public Register build(){
        return new Register(this);
   }
}
}

package za.ac.cput.Factory;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.Domain.Users.Login;
import za.ac.cput.Factory.LoginFactory;

public class LoginFactoryTest {

    @Test
    public void login(){

        Login log = LoginFactory.login("TinaK", "Kab@98");

        Assert.assertEquals("TinaK, Kab@98", log.getUsername(), log.getPassword());
    }

}
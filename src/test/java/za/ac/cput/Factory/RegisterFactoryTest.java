package za.ac.cput.Factory;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.Domain.Users.Register;
import za.ac.cput.Factory.RegisterFactory;

public class RegisterFactoryTest {

    @Test
    public void register(){

        Register reg = RegisterFactory.registration("Thato", "Kabai", "17 Feb 2002",
                "TKL", "TK2002", "TK2002");

        Assert.assertEquals("Thato", reg.getFisrtName());
    }
}
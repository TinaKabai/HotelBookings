package za.ac.cput.Factory;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.Domain.Users.Admin;
import za.ac.cput.Factory.AdminFactory;

public class AdminFactoryTest{

    @Test

    public void admin(){

        Admin a = AdminFactory.adminlogin("2002TK", "Kab@98");

        Assert.assertEquals("2002TK", a.getID());
    }

}
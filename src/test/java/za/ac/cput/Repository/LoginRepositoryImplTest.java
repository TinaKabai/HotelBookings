package za.ac.cput.Repository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import za.ac.cput.Domain.Users.Login;
import za.ac.cput.Factory.LoginFactory;
import za.ac.cput.Repository.Implementation.LoginRepositoryImpl;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class LoginRepositoryImplTest {

    private LoginRepository repository;

    private Login login;

    @Before
    public void setUp() throws Exception {

        this.repository = (LoginRepositoryImpl) LoginRepositoryImpl.getRepository();

        this.login = LoginFactory.login("TinaK", "Kab@98");
    }

    @Test
    public void d_getAll() {
        Set<Login> login = this.repository.getAll();

        System.out.println("In getAll, all = " + login);
    }

    @Test
    public void create() {

        Login created = this.repository.create(this.login);

        System.out.println("In create, created = " + created);

        Assert.assertNotNull(created);

        Assert.assertSame(created, this.login);
    }

    @Test
    public void read() {

        Login read = this.repository.read(login.getUsername());

        System.out.println("In read, read = " + read);

        d_getAll();
        Assert.assertEquals(read, login);
    }

    @Test
    public void update() {

        String newLog = "NkosiN";

        Login updated = new Login.Builder().username(newLog).build();

        System.out.println("In update, about_to_updated = " + updated);

        this.repository.update(updated);

        Assert.assertEquals(newLog, updated.getUsername());
        d_getAll();
    }

    @Test
    public void delete() {

        this.repository.delete(login.getUsername());
        d_getAll();
    }
}
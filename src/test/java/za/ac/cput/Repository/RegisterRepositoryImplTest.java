package za.ac.cput.Repository;


import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import za.ac.cput.Domain.Users.Register;
import za.ac.cput.Factory.RegisterFactory;
import za.ac.cput.Repository.Implementation.RegisterRepositoryImpl;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class RegisterRepositoryImplTest {

    private RegisterRepository repository;

    private Register register;

    @Before
    public void setUp() throws Exception {

        this.repository = (RegisterRepositoryImpl) RegisterRepositoryImpl.getRepository();

        this.register = RegisterFactory.registration("Thato", "Kabai", "17 Feb 2002",
                "TKL", "TK2002", "TK2002");
    }

    @Test
    public void d_getAll() {
        Set<Register> register = this.repository.getAll();

        System.out.println("In getAll, all = " + register);
    }

    @Test
    public void create() {

        Register created = this.repository.create(this.register);

        System.out.println("In create, created = " + created);

        Assert.assertNotNull(created);

        Assert.assertSame(created, this.register);
    }

    @Test
    public void read() {

        Register read = this.repository.read(register.getFisrtName());

        System.out.println("In read, read = " + read);

        d_getAll();
        Assert.assertEquals(read, register);
    }

    @Test
    public void update() {

        String newReg = "Obz Cafe";

        Register updated = new Register.Builder().firstName(newReg).build();

        System.out.println("In update, about_to_updated = " + updated);

        this.repository.update(updated);

        Assert.assertEquals(newReg, updated.getFisrtName());
        d_getAll();
    }

    @Test
    public void delete() {

        this.repository.delete(register.getFisrtName());
        d_getAll();
    }
}
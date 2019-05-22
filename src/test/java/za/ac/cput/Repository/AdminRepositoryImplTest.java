package za.ac.cput.Repository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import za.ac.cput.Domain.Users.Admin;
import za.ac.cput.Factory.AdminFactory;
import za.ac.cput.Repository.Implementation.AdminRepositoryImpl;

import java.util.Map;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class AdminRepositoryImplTest {

        private AdminRepository repository;

        private Admin admin;

        @Before
        public void setUp() throws Exception {

            this.repository = (AdminRepositoryImpl) AdminRepositoryImpl.getRepository();

            this.admin = AdminFactory.adminlogin("2002TK", "Kab@98");
        }

    @Test
    public void d_getAll() {
        Map<Admin, Admin> admin = this.repository.getAll();

        System.out.println("In getAll, all = " + admin);
    }

        @Test
        public void create() {

            Admin created = this.repository.create(this.admin);

            System.out.println("In create, created = " + created);

            Assert.assertNotNull(created);

            Assert.assertSame(created, this.admin);
        }

        @Test
        public void read() {

            Admin read = this.repository.read(admin.getID());

            System.out.println("In read, read = " + read);

            d_getAll();
            Assert.assertEquals(read, admin);
        }

    @Test
    public void update() {

        String newAdmin = "1998NN";

        Admin updated = new Admin.Builder().ID(newAdmin).build();

        System.out.println("In update, about_to_updated = " + updated);

        this.repository.update(updated);

        Assert.assertEquals(newAdmin, updated.getID());
        d_getAll();
    }

        @Test
        public void delete() {

            this.repository.delete(admin.getID());
            d_getAll();
        }
    }
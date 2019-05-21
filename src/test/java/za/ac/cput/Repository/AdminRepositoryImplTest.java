package za.ac.cput.Repository;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import za.ac.cput.Domain.Users.Admin;
import za.ac.cput.Factory.AdminFactory;
import za.ac.cput.Repository.Implementation.AdminRepositoryImpl;

import java.util.Map;
import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class AdminRepositoryImplTest {

        private AdminRepository repository;

        private Admin admin;


        private Admin getSavedAdmin() {

            Map<Admin, Admin> savedAdmins = this.repository.getAll();

            return savedAdmins.values().iterator().next();
        }

        @Before
        public void setUp() throws Exception {

            this.repository = AdminRepositoryImpl.getRepository();

            this.admin = AdminFactory.adminlogin("2002TK", "Kab@98");
        }

        @Test
        public void a_create() {

            Admin created = this.repository.create(this.admin);

            System.out.println("In create, created = " + created);

            d_getAll();

            Assert.assertSame(created, this.admin);
        }

        @Test
        public void b_read() {

            Admin savedAdmins = getSavedAdmin();

            System.out.println("In read, adminId = "+ savedAdmins.getID());

            Admin read = this.repository.read(savedAdmins.getID());

            System.out.println("In read, read = " + read);

            d_getAll();
            Assert.assertEquals(savedAdmins, read);
        }

        @Test
        public void e_delete() {

            Admin savedAdmin = getSavedAdmin();

            this.repository.delete(savedAdmin.getID());

            d_getAll();
        }

        @Test
        public void c_update() {

            String newAd = "New Administrator Name";

            //Admin admin = new Admin.Builder().copy(getSavedAdmin()).ID(newAd).build();

            System.out.println("In update, about_to_updated = " + admin);

            Admin updated = this.repository.update(admin);

            System.out.println("In update, updated = " + updated);

            Assert.assertSame(newAd, updated.getID());

            d_getAll();
        }

        @Test
        public void d_getAll() {
            Map<Admin, Admin> all = this.repository.getAll();

            System.out.println("In getAll, all = " + all);

            Assert.assertSame(1, all.size());
        }
    }
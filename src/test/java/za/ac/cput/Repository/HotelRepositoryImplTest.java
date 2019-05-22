package za.ac.cput.Repository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import za.ac.cput.Domain.Content.Hotel;
import za.ac.cput.Factory.HotelFactory;
import za.ac.cput.Repository.Implementation.HotelRepositoryImpl;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class HotelRepositoryImplTest {


        private HotelRepository repository;

        private Hotel hotel;

    @Before
    public void setUp() throws Exception {

        this.repository = (HotelRepositoryImpl) HotelRepositoryImpl.getRepository();

        this.hotel = HotelFactory.chooseHotel("Cape Town ", 8000, "Cape Sun Hotel", "23 Strand St",
                "021 488 5100", "https://southern-sun-cape-sun.capetown-hotels-za.com/en/");
    }

    @Test
    public void d_getAll() {
        Set<Hotel> hotel = this.repository.getAll();

        System.out.println("In getAll, all = " + hotel);
    }

    @Test
    public void create() {

        Hotel created = this.repository.create(this.hotel);

        System.out.println("In create, created = " + created);

        Assert.assertNotNull(created);

        Assert.assertSame(created, this.hotel);
    }

    @Test
    public void read() {

        Hotel read = this.repository.read(hotel.getHotelName());

        System.out.println("In read, read = " + read);

        d_getAll();
        Assert.assertEquals(read, hotel);
    }

    @Test
    public void update() {

        String newHotel = "Protea Hotel";

        Hotel updated = new Hotel.Builder().hotelName(newHotel).build();

        System.out.println("In update, about_to_updated = " + updated);

        this.repository.update(updated);

        Assert.assertEquals(newHotel, updated.getHotelName());
        d_getAll();
    }

    @Test
    public void delete() {

        this.repository.delete(hotel.getHotelName());
        d_getAll();
    }
}
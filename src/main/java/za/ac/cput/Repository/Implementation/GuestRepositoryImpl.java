package za.ac.cput.Repository.Implementation;

import com.sun.org.apache.xpath.internal.operations.String;
import za.ac.cput.Domain.Content.Guest;
import za.ac.cput.Repository.GuestRepository;

import java.util.HashSet;
import java.util.Set;

public class GuestRepositoryImpl implements GuestRepository {

    private static GuestRepositoryImpl repository = null;
    private Set<Guest> guests;

    private GuestRepositoryImpl() {
        this.guests = new HashSet<Guest>();
    }

    public static GuestRepositoryImpl getRepository() {
        if (repository == null) repository = new GuestRepositoryImpl();
        return repository;
    }


    public Guest create(Guest guest) {
        this.guests.add(guest);
        return guest;
    }

    public Guest read(String name) {
        // find the course that matches the id and return it if exist
        return null;
    }

    public void delete(String name) {
        // find the course, delete it if it exist
    }

    public Guest update(Guest guest) {
        // find the course, update it and delete it if it exists
        return guest;
    }

    public Set<Guest> getAll(){
        return this.guests;
    }
}

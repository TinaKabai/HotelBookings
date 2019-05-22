package za.ac.cput.Repository.Implementation;

import za.ac.cput.Domain.Content.Guest;
import za.ac.cput.Repository.GuestRepository;

import java.util.HashMap;
import java.util.Map;

public class GuestRepositoryImpl implements  GuestRepository{

    private static GuestRepositoryImpl repository = null;
    private Map<Guest, Guest> guests;

    private GuestRepositoryImpl() {
        this.guests = new HashMap<>();
    }

    private Guest findGuests(String guestNm) {
        return this.guests.values().stream()
                .filter(guest -> guest.getName().equals(guestNm))
                .findAny()
                .orElse(null);
    }

    public static GuestRepositoryImpl getRepository() {
        if (repository == null) repository = new GuestRepositoryImpl();
        return repository;
    }

    public Guest create(Guest guest) {
        this.guests.put(guest, guest);
        return guest;
    }

    public Guest update(Guest guest) {

        Guest toDelete = findGuests(guest.getName());
        if(toDelete != null) {
            this.guests.remove(toDelete);
            return create(guest);
        }
        return null;
    }
    public void delete(String guestNm) {
        Guest guest = findGuests(guestNm);
        if (guest != null) this.guests.remove(guest);

    }
    public Guest read(String guestNm) {
        Guest guest = findGuests(guestNm);
        return guest;
    }

    public Map<Guest, Guest> getAll() {
        return this.guests;
    }
}

package za.ac.cput.Repository;

import za.ac.cput.Domain.Content.Guest;

import java.util.Map;

public interface GuestRepository extends IRepository<Guest, String> {

    Map<Guest, Guest> getAll();
}

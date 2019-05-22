package za.ac.cput.Service;

import za.ac.cput.Domain.Content.Guest;

import java.util.Map;

public interface GuestService extends IService<Guest, String> {

    Map<Guest, Guest> getAll();
}

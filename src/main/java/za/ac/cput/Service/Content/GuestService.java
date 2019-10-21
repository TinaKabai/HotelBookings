package za.ac.cput.Service.Content;

import za.ac.cput.Domain.Content.Guest;
import za.ac.cput.Service.GenIService;

import java.util.List;
import java.util.Map;

public interface GuestService extends GenIService<Guest, String> {

    Guest retrieveById(String id);
    List<Guest> getAll();
}

package za.ac.cput.Service.Content;

import za.ac.cput.Domain.Content.Deluxe;
import za.ac.cput.Service.GenIService;

import java.util.List;
import java.util.Map;

public interface DeluxeService extends GenIService<Deluxe, String> {

    Deluxe retrieveById(String id);
    List<Deluxe> getAll();
}

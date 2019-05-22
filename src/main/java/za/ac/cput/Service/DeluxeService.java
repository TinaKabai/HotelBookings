package za.ac.cput.Service;

import za.ac.cput.Domain.Content.Deluxe;

import java.util.Map;

public interface DeluxeService extends IService<Deluxe, String> {

    Map<Deluxe, Deluxe> getAll();
}

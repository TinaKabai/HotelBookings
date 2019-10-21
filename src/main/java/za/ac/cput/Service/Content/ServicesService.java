package za.ac.cput.Service.Content;

import za.ac.cput.Domain.Content.Services;
import za.ac.cput.Service.GenIService;

import java.util.List;
import java.util.Set;

public interface ServicesService extends GenIService<Services, String> {

    Services retrieveById(String id);
    List<Services> getAll();
}

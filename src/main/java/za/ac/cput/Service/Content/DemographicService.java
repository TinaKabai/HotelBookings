package za.ac.cput.Service.Content;

import za.ac.cput.Domain.Content.Demographic;
import za.ac.cput.Service.GenIService;

import java.util.List;
import java.util.Map;

public interface DemographicService extends GenIService<Demographic, String> {

    Demographic retrieveById(String id);
    List<Demographic> getAll();
}

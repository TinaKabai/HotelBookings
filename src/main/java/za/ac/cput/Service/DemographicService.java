package za.ac.cput.Service;

import za.ac.cput.Domain.Content.Demographic;

import java.util.Map;

public interface DemographicService extends IService<Demographic, String> {

    Map<Demographic, Demographic> getAll();
}

package za.ac.cput.Service.Activities;

import za.ac.cput.Domain.Activites.Sport;
import za.ac.cput.Service.GenIService;

import java.util.List;
import java.util.Set;

public interface SportService extends GenIService<Sport, String> {

    Sport retrieveById(String id);
    List<Sport> getAll();
}

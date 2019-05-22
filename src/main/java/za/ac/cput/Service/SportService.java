package za.ac.cput.Service;

import za.ac.cput.Domain.Activites.Sport;

import java.util.Set;

public interface SportService extends IService<Sport, String> {

    Set<Sport> getAll();
}

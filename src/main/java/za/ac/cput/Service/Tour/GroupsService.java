package za.ac.cput.Service.Tour;

import za.ac.cput.Domain.Tour.Groups;
import za.ac.cput.Service.GenIService;

import java.util.List;
import java.util.Map;

public interface GroupsService extends GenIService<Groups, String> {

    Groups retrieveById(String id);
    List<Groups> getAll();
}

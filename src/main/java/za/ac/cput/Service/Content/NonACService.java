package za.ac.cput.Service.Content;

import za.ac.cput.Domain.Content.NonAC;
import za.ac.cput.Service.GenIService;

import java.util.List;
import java.util.Set;

public interface NonACService extends GenIService<NonAC, String> {

    NonAC retrieveById(String id);
    List<NonAC> getAll();
}

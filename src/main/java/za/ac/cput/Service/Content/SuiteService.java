package za.ac.cput.Service.Content;

import za.ac.cput.Domain.Content.Suite;
import za.ac.cput.Service.GenIService;

import java.util.List;
import java.util.Set;

public interface SuiteService extends GenIService<Suite, String> {

    Suite retrieveById(String id);
    List<Suite> getAll();
}

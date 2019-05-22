package za.ac.cput.Service;

import za.ac.cput.Domain.Content.Suite;

import java.util.Set;

public interface SuiteService extends IService<Suite, String> {

    Set<Suite> getAll();
}

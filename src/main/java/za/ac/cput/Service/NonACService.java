package za.ac.cput.Service;

import za.ac.cput.Domain.Content.NonAC;

import java.util.Set;

public interface NonACService extends IService<NonAC, String> {

    Set<NonAC> getAll();
}

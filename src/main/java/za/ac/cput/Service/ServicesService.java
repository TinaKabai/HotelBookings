package za.ac.cput.Service;

import za.ac.cput.Domain.Content.Services;

import java.util.Set;

public interface ServicesService extends IService<Services, String> {

    Set<Services> getAll();
}

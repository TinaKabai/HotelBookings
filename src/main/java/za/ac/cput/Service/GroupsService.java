package za.ac.cput.Service;

import za.ac.cput.Domain.Tour.Groups;

import java.util.Map;

public interface GroupsService extends IService<Groups, String> {

    Map<Groups, Groups> getAll();
}

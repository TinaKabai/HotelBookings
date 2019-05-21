package za.ac.cput.Repository;

import za.ac.cput.Domain.Tour.Groups;

import java.util.Map;
import java.util.Set;

public interface GroupsRepository extends IRepository<Groups, String> {

    Map<Groups, Groups> getAll();
}

/*package za.ac.cput.Repository.Implementation;

import org.springframework.stereotype.Repository;
import za.ac.cput.Domain.Tour.Groups;
import za.ac.cput.Repository.tour.GroupsRepository;

import java.util.HashMap;
import java.util.Map;

@Repository*/
/*public class GroupsRepositoryImpl implements GroupsRepository {

    private static GroupsRepositoryImpl repository = null;
    private Map<Groups, Groups> groups;

    private GroupsRepositoryImpl() {
        this.groups = new HashMap<>();
    }

    private Groups theGroup(String gName) {
        return this.groups.values().stream()
                .filter(group -> group.getGroupName().trim().equals(gName))
                .findAny()
                .orElse(null);
    }

    public static GroupsRepositoryImpl getRepository() {
        if (repository == null) repository = new GroupsRepositoryImpl();
        return repository;
    }
    public Groups create(Groups group) {
        this.groups.put(group, group);
        return group;
    }

    public Groups read(final String gName){
        Groups group = theGroup(gName);
        return group;
    }

    public void delete(String gName) {
        Groups group = theGroup(gName);
        if (group != null) this.groups.remove(group);
    }

    public Groups update(Groups group) {
        Groups toDelete = theGroup(group.getGroupName());
        if(toDelete != null) {
            this.groups.remove(toDelete);
            return create(group);
        }
        return null;
    }

    public Map<Groups, Groups> getAll(){
        return this.groups;
    }
}*/

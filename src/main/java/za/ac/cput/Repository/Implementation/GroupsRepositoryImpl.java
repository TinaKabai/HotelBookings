package za.ac.cput.Repository.Implementation;

import za.ac.cput.Domain.Tour.Groups;

import java.util.HashSet;
import java.util.Set;

public class GroupsRepositoryImpl {

    private static GroupsRepositoryImpl repository = null;
    private Set<Groups> groups;

    private GroupsRepositoryImpl() {
        this.groups = new HashSet<Groups>();
    }

    public static GroupsRepositoryImpl getRepository() {
        if (repository == null) repository = new GroupsRepositoryImpl();
        return repository;
    }
    public Groups create(Groups group) {
        this.groups.add(group);
        return group;
    }

    public Groups read(String name) {
        // find the course that matches the id and return it if exist
        return null;
    }

    public void delete(String name) {
        // find the course, delete it if it exist
    }

    public Groups update(Groups attendance) {
        // find the course, update it and delete it if it exists
        return attendance;
    }

    public Set<Groups> getAll(){
        return this.groups;
    }
}

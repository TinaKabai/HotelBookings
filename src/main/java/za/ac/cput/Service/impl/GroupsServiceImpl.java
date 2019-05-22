package za.ac.cput.Service.impl;

import za.ac.cput.Domain.Tour.Groups;
import za.ac.cput.Repository.GroupsRepository;
import za.ac.cput.Repository.Implementation.GroupsRepositoryImpl;
import za.ac.cput.Service.GroupsService;

import java.util.Map;

public class GroupsServiceImpl implements GroupsService {

    private GroupsServiceImpl service = null;
    private GroupsRepository repository;

    private GroupsServiceImpl(){
        this.repository = GroupsRepositoryImpl.getRepository();
    }

    public GroupsServiceImpl getService(){
        if (service == null) service = new GroupsServiceImpl();
        return null;
    }

    @Override
    public Groups create(Groups groups) {
        return this.repository.create(groups);
    }

    @Override
    public Groups update(Groups groups) {
        return this.repository.update(groups);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Groups read(String s) {
        return this.repository.read(s);
    }

    public Map<Groups, Groups> getAll() {
        return this.repository.getAll();
    }
}

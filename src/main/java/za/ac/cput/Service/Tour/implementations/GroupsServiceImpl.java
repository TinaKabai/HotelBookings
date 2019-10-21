package za.ac.cput.Service.Tour.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Domain.Tour.Groups;
import za.ac.cput.Repository.tour.GroupsRepository;
import za.ac.cput.Service.Tour.GroupsService;

import java.util.List;

@Service
public class GroupsServiceImpl implements GroupsService {

    private static GroupsService service = null;

    @Autowired
    private GroupsRepository repo;

    private GroupsServiceImpl() {

    }

    public static GroupsService getService() {
        if (service == null) service = new GroupsServiceImpl();
        return service;
    }

    @Override
    public Groups retrieveById(String id) {
        List<Groups> groups = getAll();
        for (Groups g : groups) {
            if (g.getGroupName().equals(id)) return g;
        }
        return null;
    }

    @Override
    public List<Groups> getAll() {
        return this.repo.findAll();
    }

    public Groups create(Groups group) {
        return this.repo.save(group);
    }


    public Groups read(String s) {
        return this.repo.findById(s).orElse(null);
    }


    public Groups update(Groups group) {
        return this.repo.save(group);
    }

    @Override
    public void delete(String s) {
        this.repo.deleteById(s);
    }
}

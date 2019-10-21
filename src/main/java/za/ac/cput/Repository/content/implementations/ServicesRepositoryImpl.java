/*package za.ac.cput.Repository.Implementation;

import org.springframework.stereotype.Repository;
import za.ac.cput.Domain.Content.Services;
import za.ac.cput.Repository.content.ServicesRepository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class ServicesRepositoryImpl implements ServicesRepository {

    private static ServicesRepositoryImpl repository = null;
    private Set<Services> services;

    private ServicesRepositoryImpl() {
        this.services = new HashSet<>();
    }

    private Services theSerices(String serviceName) {
        return this.services.stream()
                .filter(service -> service.getServName().trim().equals(serviceName))
                .findAny()
                .orElse(null);
    }

    public static ServicesRepositoryImpl getRepository() {
        if (repository == null) repository = new ServicesRepositoryImpl();
        return repository;
    }
    public Services create(Services services1) {
        this.services.add(services1);
        return services1;
    }

    public Services read(final String serviceName){
        Services service = theSerices(serviceName);
        return service;
    }

    public void delete(String roomType) {
        Services service = theSerices(roomType);
        if (service != null) this.services.remove(service);
    }

    public Services update(Services service) {
        Services toDelete = theSerices(service.getServName());
        if(toDelete != null) {
            this.services.remove(toDelete);
            return create(service);
        }
        return null;
    }

    public Set<Services> getAll(){
        return this.services;
    }
}*/

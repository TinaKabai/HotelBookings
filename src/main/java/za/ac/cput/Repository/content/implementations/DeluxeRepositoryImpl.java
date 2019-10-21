package za.ac.cput.Repository.content.implementations;

/*import org.springframework.stereotype.Repository;
import za.ac.cput.Domain.Content.Deluxe;
import za.ac.cput.Repository.content.DeluxeRepository;

import java.util.HashMap;
import java.util.Map;

@Repository*/
/*public class DeluxeRepositoryImpl implements DeluxeRepository {

    private static DeluxeRepositoryImpl repository = null;
    private Map<Deluxe, Deluxe> deluxes;

    private DeluxeRepositoryImpl() {
        this.deluxes = new HashMap<>();
    }

    private Deluxe isDeluxe(String roomType) {
        return this.deluxes.values().stream()
                .filter(deluxe -> deluxe.getRoomType().trim().equals(roomType))
                .findAny()
                .orElse(null);
    }

    public static DeluxeRepositoryImpl getRepository() {
        if (repository == null) repository = new DeluxeRepositoryImpl();
        return repository;
    }

    public Deluxe create(Deluxe deluxe) {
        this.deluxes.put(deluxe, deluxe);
        return deluxe;
    }

    public Deluxe read(final String roomType){
        Deluxe deluxe = isDeluxe(roomType);
        return deluxe;
    }

    public void delete(String roomType) {
        Deluxe deluxe = isDeluxe(roomType);
        if (deluxe != null) this.deluxes.remove(deluxe);
    }

    public Deluxe update(Deluxe deluxe) {
        Deluxe toDelete = isDeluxe(deluxe.getRoomType());
        if(toDelete != null) {
            this.deluxes.remove(toDelete);
            return create(deluxe);
        }
        return null;
    }
    public Map<Deluxe, Deluxe> getAll(){
        return this.deluxes;
    }
}
*/
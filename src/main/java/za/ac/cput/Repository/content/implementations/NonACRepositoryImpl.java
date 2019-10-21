/*package za.ac.cput.Repository.Implementation;

import org.springframework.stereotype.Repository;
import za.ac.cput.Domain.Content.NonAC;
import za.ac.cput.Repository.content.NonACRepository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Repository
public class NonACRepositoryImpl implements NonACRepository {

    private static NonACRepositoryImpl repository = null;
    private Set<NonAC> nonACs;

    private NonACRepositoryImpl() {
        this.nonACs = new HashSet<>();
    }

    private NonAC isNonAC(String roomType) {
        return this.nonACs.stream()
                .filter(nonAC -> nonAC.getRoomType().trim().equals(roomType))
                .findAny()
                .orElse(null);
    }

    public static NonACRepositoryImpl getRepository() {
        if (repository == null) repository = new NonACRepositoryImpl();
        return repository;
    }

    public NonAC create(NonAC nonAC) {
        this.nonACs.add(nonAC);
        return nonAC;
    }

    public NonAC read(final String roomType){
        NonAC nonAC = isNonAC(roomType);
        return nonAC;
    }

    public void delete(String roomType) {
        NonAC nonAC = isNonAC(roomType);
        if (nonAC != null) this.nonACs.remove(nonAC);
    }

    public NonAC update(NonAC nonAC) {
        NonAC toDelete = isNonAC(nonAC.getRoomType());
        if(toDelete != null) {
            this.nonACs.remove(toDelete);
            return create(nonAC);
        }
        return null;
    }
    public Set<NonAC> getAll(){
        return this.nonACs;
    }
}*/

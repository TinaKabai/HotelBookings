package za.ac.cput.Repository;

import com.sun.org.apache.xpath.internal.operations.String;
import za.ac.cput.Domain.Content.Guest;

import java.util.Set;

public interface GuestRepository extends IRepository<Guest, String> {

    Set<Guest> getAll();
}

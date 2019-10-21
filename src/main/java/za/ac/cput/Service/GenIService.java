package za.ac.cput.Service;

public interface GenIService<T, ID> {

    T create(T t);
    T read(ID id);
    T update(T t);
    void delete(ID id);
}

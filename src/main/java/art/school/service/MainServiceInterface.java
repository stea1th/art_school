package art.school.service;


import java.util.List;

public interface MainServiceInterface<T> {

    T create(T t);

    void delete(int id);

    T get(int id);

    void update(T t);

    List<T> getAll();
}

package art.school.repository;

import java.util.List;

public interface MainRepoInterface<T> {
    T save(T t);
    boolean delete(int id);
    T get(int id);
    List<T> getAll();
}

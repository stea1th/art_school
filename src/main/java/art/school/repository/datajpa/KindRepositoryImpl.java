package art.school.repository.datajpa;

import art.school.entity.Kind;
import art.school.repository.KindRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class KindRepositoryImpl implements KindRepository {

    private static final Sort SORT_BY_NAME = new Sort(Sort.Direction.DESC, "name");

    @Autowired
    CrudKindRepository crudKindRepository;

    @Override
    public Kind save(Kind kind) {
        return crudKindRepository.save(kind);
    }

    @Override
    public boolean delete(int id) {
        return crudKindRepository.delete(id) != 0;
    }

    @Override
    public Kind get(int id) {
        return crudKindRepository.findById(id).orElse(null);
    }

    @Override
    public List<Kind> getAll() {
        return crudKindRepository.findAll(SORT_BY_NAME);
    }
}

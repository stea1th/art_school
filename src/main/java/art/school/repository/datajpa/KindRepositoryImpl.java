package art.school.repository.datajpa;

import art.school.entity.Kind;
import art.school.repository.KindRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class KindRepositoryImpl implements KindRepository {

    @Autowired
    CrudKindRepository crudKindRepository;

    @Override
    public Kind get(int id) {
        return crudKindRepository.findById(id).orElse(null);
    }
}

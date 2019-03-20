package art.school.repository.datajpa;

import art.school.entity.Thema;
import art.school.repository.ThemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ThemaRepositoryImpl implements ThemaRepository {

    @Autowired
    CrudThemaRepository repository;


    @Override
    public Thema save(Thema thema) {
        return repository.save(thema);
    }

    @Override
    public boolean delete(int id) {
        return repository.delete(id) != 0;
    }

    @Override
    public Thema get(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Thema> getAll() {
        return repository.findAllAsList();
    }

    public Page<Thema> getAll(Pageable pageable) {
        return repository.findAllThis(pageable);
    }

    public long count(){
        return repository.count();
    }
}

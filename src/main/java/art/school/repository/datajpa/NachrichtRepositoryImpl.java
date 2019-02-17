package art.school.repository.datajpa;

import art.school.entity.Nachricht;
import art.school.repository.NachrichtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class NachrichtRepositoryImpl implements NachrichtRepository {

    @Autowired
    private CrudNachrichtRepository repository;

    @Override
    public List<Nachricht> getAllByThemaId(int id) {
        return repository.findAllByThemaId(id);
    }

    @Override
    @Transactional
    public Nachricht save(Nachricht nachricht) {
        return repository.save(nachricht);
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Nachricht get(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Nachricht> getAll() {
        return null;
    }
}

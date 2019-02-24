package art.school.repository.datajpa;

import art.school.entity.NachrichtUpdater;
import art.school.entity.NachrichtUpdaterId;
import art.school.repository.NachrichtUpdaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NachrichtUpdaterRepositoryImpl implements NachrichtUpdaterRepository {

    @Autowired
    private CrudNachrichtUpdaterRepository repository;

    @Override
    public NachrichtUpdater save(NachrichtUpdater nachrichtUpdater) {
        return repository.save(nachrichtUpdater);
    }

    @Override
    public NachrichtUpdater get(NachrichtUpdaterId updaterId) {
        return repository.findById(updaterId).orElse(null);
    }

    @Override
    public void delete(NachrichtUpdater nachrichtUpdater) {
        repository.delete(nachrichtUpdater);
    }
}

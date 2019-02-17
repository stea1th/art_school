package art.school.service;

import art.school.entity.Nachricht;
import art.school.repository.NachrichtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NachrichtServiceImpl implements NachrichtService {

    @Autowired
    private NachrichtRepository repository;


    @Override
    public List<Nachricht> getAllByThemaId(int id) {
        return repository.getAllByThemaId(id);
    }

    @Override
    public Nachricht create(Nachricht nachricht) {
        return repository.save(nachricht);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Nachricht get(int id) {
        return repository.get(id);
    }

    @Override
    public void update(Nachricht nachricht) {

    }

    @Override
    public List<Nachricht> getAll() {
        return null;
    }
}

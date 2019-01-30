package art.school.service;

import art.school.entity.Thema;
import art.school.repository.ThemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThemaServiceImpl implements ThemaService {

    @Autowired
    private ThemaRepository repository;

    @Override
    public Thema create(Thema thema) {
        return repository.save(thema);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public Thema get(int id) {
        return repository.get(id);
    }

    @Override
    public void update(Thema thema) {
        repository.save(thema);

    }

    @Override
    public List<Thema> getAll() {
        return repository.getAll();
    }
}

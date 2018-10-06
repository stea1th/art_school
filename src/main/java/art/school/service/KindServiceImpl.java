package art.school.service;

import art.school.entity.Kind;
import art.school.repository.KindRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class KindServiceImpl implements KindService {

    @Autowired
    KindRepository repository;

    @Override
    public Kind create(Kind kind) {
        return repository.save(kind);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);

    }

    @Override
    public Kind get(int id) {
        return repository.get(id);
    }

    @Override
    public void update(Kind kind) {
        repository.save(kind);

    }

    @Override
    public List<Kind> getAll() {
        return repository.getAll();
    }

    @Override
    @Transactional
    public void toggleAktiv(int id) {
        Kind kind = get(id);
        kind.setAktiv(!kind.isAktiv());
    }
}

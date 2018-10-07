package art.school.service;

import art.school.entity.Kind;
import art.school.repository.KindRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

import static art.school.util.ValidationUtil.checkNotFoundWithId;

@Service
public class KindServiceImpl implements KindService {

    @Autowired
    private KindRepository repository;

    @Override
    public Kind create(Kind kind) {
        Assert.notNull(kind, "kind must not be null");
        return repository.save(kind);
    }

    @Override
    public void delete(int id) {
       checkNotFoundWithId(repository.delete(id), id);

    }

    @Override
    public Kind get(int id) {
        return checkNotFoundWithId(repository.get(id), id);
    }

    @Override
    public void update(Kind kind) {
        Assert.notNull(kind, "kind must not be null");
        checkNotFoundWithId(repository.save(kind), kind.getId());

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

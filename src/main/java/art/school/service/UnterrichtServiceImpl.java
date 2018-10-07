package art.school.service;

import art.school.entity.Unterricht;
import art.school.repository.UnterrichtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

import static art.school.util.ValidationUtil.checkNotFoundWithId;

@Service
public class UnterrichtServiceImpl implements UnterrichtService {

    @Autowired
    private UnterrichtRepository repository;

    @Override
    public Unterricht create(Unterricht unterricht, Integer... arr) {
        Assert.notNull(unterricht, "unterricht must not be null");
        return repository.save(unterricht, arr);
    }

    @Override
    public void update(Unterricht unterricht, Integer... arr) {
        Assert.notNull(unterricht, "unterricht must not be null");
        checkNotFoundWithId(repository.save(unterricht, arr), unterricht.getId());

    }

    @Override
    @Transactional
    public void toggleBezahlt(int id) {
        Unterricht u = get(id);
        u.setBezahlt(!u.isBezahlt());
    }

    @Override
    public Unterricht create(Unterricht unterricht) {
        return null;
    }

    @Override
    public void delete(int id) {
       checkNotFoundWithId(repository.delete(id), id);

    }

    @Override
    public Unterricht get(int id) {
        return checkNotFoundWithId(repository.get(id), id);
    }

    @Override
    public void update(Unterricht unterricht) {

    }

    @Override
    public List<Unterricht> getAll() {
        return repository.getAll();
    }
}

package art.school.service;

import art.school.entity.Unterricht;
import art.school.repository.UnterrichtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UnterrichtServiceImpl implements UnterrichtService {

    @Autowired
    private UnterrichtRepository repository;

    @Override
    public Unterricht create(Unterricht unterricht, Integer... arr) {
        return repository.save(unterricht, arr);
    }

    @Override
    public void update(Unterricht unterricht, Integer... arr) {
        repository.save(unterricht, arr);

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
        repository.delete(id);

    }

    @Override
    public Unterricht get(int id) {
        return repository.get(id);
    }

    @Override
    public void update(Unterricht unterricht) {

    }

    @Override
    public List<Unterricht> getAll() {
        return repository.getAll();
    }
}

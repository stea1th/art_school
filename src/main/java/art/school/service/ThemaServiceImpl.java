package art.school.service;

import art.school.entity.Thema;
import art.school.repository.ThemaRepository;
import art.school.to.ThemaTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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
    @Transactional
    public List<Thema> getAll() {
        return repository.getAll();
    }

    @Override
    @Transactional
    public Page<Thema> getAll(Pageable pageable) {
        return repository.getAll(pageable);
    }

    @Transactional
    public List<ThemaTo> getAllTos(Pageable pageable){
        return getAll(pageable).stream()
                .map(ThemaTo::new)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<ThemaTo> getAllTos() {
        return getAll().stream()
                .map(ThemaTo::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public ThemaTo getTo(int  id){
        return new ThemaTo(get(id));
    }

    @Override
    public long count() {
        return repository.count();
    }


}

package art.school.service;

import art.school.entity.Zahlung;
import art.school.repository.ZahlungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZahlungServiceImpl implements ZahlungService {

    @Autowired
    ZahlungRepository repository;

    @Override
    public Zahlung create(Zahlung zahlung) {
        return repository.save(zahlung);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);

    }

    @Override
    public Zahlung get(int id) {
        return repository.get(id);
    }

    @Override
    public void update(Zahlung zahlung) {
        repository.save(zahlung);

    }

    @Override
    public List<Zahlung> getAll() {
        return repository.getAll();
    }
}

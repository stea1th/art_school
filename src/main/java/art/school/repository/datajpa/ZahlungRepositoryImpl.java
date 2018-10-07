package art.school.repository.datajpa;

import art.school.entity.Zahlung;
import art.school.repository.ZahlungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ZahlungRepositoryImpl implements ZahlungRepository {

    @Autowired
    CrudZahlungRepository repository;

    @Override
    public Zahlung save(Zahlung zahlung) {
        return repository.save(zahlung);
    }

    @Override
    public boolean delete(int id) {
        return repository.delete(id) != 0;
    }

    @Override
    public Zahlung get(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Zahlung> getAll() {
        return repository.findAll();
    }
}

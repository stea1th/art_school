package art.school.service;

import art.school.entity.Zahlung;
import art.school.repository.ZahlungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

import static art.school.util.ValidationUtil.checkNotFoundWithId;

@Service
public class ZahlungServiceImpl implements ZahlungService {

    @Autowired
    private ZahlungRepository repository;

    @Override
    public Zahlung create(Zahlung zahlung) {
        Assert.notNull(zahlung, "zahlung must not be null");
        return repository.save(zahlung);
    }

    @Override
    public void delete(int id) {
      checkNotFoundWithId(repository.delete(id), id);
    }

    @Override
    public Zahlung get(int id) {
        return checkNotFoundWithId(repository.get(id), id);
    }

    @Override
    public void update(Zahlung zahlung) {
        Assert.notNull(zahlung, "zahlung must not be null");
        checkNotFoundWithId(repository.save(zahlung), zahlung.getId());
    }

    @Override
    public List<Zahlung> getAll() {
        return repository.getAll();
    }

    @Override
    @Transactional
    public boolean toggleAktiv(int id) {
        Zahlung zahlung = get(id);
        zahlung.setAktiv(!zahlung.isAktiv());
        return zahlung.isAktiv();
    }
}

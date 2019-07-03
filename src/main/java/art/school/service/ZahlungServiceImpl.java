package art.school.service;

import art.school.entity.Zahlung;
import art.school.helper.ZahlungHelper;
import art.school.repository.ZahlungRepository;
import art.school.to.ZahlungTo;
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

    @Autowired
    private ZahlungHelper zahlungHelper;

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
    @Transactional
    public Zahlung get(int id) {
        return checkNotFoundWithId(repository.get(id), id);
    }

    @Transactional
    public ZahlungTo getTo(int id) {
        return zahlungHelper.createTo(get(id));
    }

    @Override
    @Transactional
    public void update(Zahlung zahlung) {
        Assert.notNull(zahlung, "zahlung must not be null");
        checkNotFoundWithId(repository.save(zahlung), zahlung.getId());
    }

    @Override
    public List<Zahlung> getAll() {
        return repository.getAll();
    }

    @Transactional
    public List<ZahlungTo> getAllTos() {
        return zahlungHelper.transformTos(getAll());
    }

    @Override
    @Transactional
    public boolean toggleAktiv(int id) {
        Zahlung zahlung = get(id);
        zahlung.setAktiv(!zahlung.isAktiv());
        return zahlung.isAktiv();
    }

    @Transactional
    public List<ZahlungTo> onlyAktiv() {
        return zahlungHelper.transformTos(repository.getOnlyAktiv());
    }

    @Override
    public Zahlung createWithTo(ZahlungTo to) {
        Zahlung z = to.isNew() ? zahlungHelper.createZahlung(to) : zahlungHelper.updateZahlung(get(to.getId()), to);
        return create(z);
    }
}

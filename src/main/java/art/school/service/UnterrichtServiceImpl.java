package art.school.service;

import art.school.entity.Unterricht;
import art.school.repository.UnterrichtRepository;
import art.school.to.RequestUnterrichtTo;
import art.school.to.UserTo;
import art.school.to.ZahlungTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static art.school.util.ValidationUtil.assureIdConsistent;
import static art.school.util.ValidationUtil.checkNew;
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
    @Transactional
    public void toggleBezahlt(int id) {
        Unterricht u = get(id);
        u.setBezahlt(!u.isBezahlt());
    }

    @Override
    public Unterricht createFromTo(RequestUnterrichtTo unterrichtTo) {
        Unterricht u = unterrichtTo.createUnterricht();
        checkNew(u);
        return create(u, unterrichtTo.getKind(), unterrichtTo.getZahlung());
    }

    @Override
    @Transactional
    public void updateFromTo(RequestUnterrichtTo unterrichtTo) {
        Unterricht u = get(unterrichtTo.getId());
        u.setDatum(LocalDateTime.of(LocalDate.parse(unterrichtTo.getDatum()),
                LocalTime.parse(unterrichtTo.getZeit())));
        u.setBezahlt(unterrichtTo.isBezahlt());
        u.setNotiz(unterrichtTo.getNotiz());
        assureIdConsistent(u, u.getId());
        create(u, unterrichtTo.getKind()!=null? unterrichtTo.getKind() : u.getUser().getId(),
                unterrichtTo.getZahlung()!=null? unterrichtTo.getZahlung() : u.getZahlung().getId());

    }

    @Override
    @Transactional
    public RequestUnterrichtTo createRequestUnterrichtTo(int id) {
        Unterricht u = get(id);
        RequestUnterrichtTo to = new RequestUnterrichtTo(u);
        to.setKindTo(new UserTo(u.getUser()));
        to.setZahlungTo(new ZahlungTo(u.getZahlung()));
        return to;
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
        Assert.notNull(unterricht, "unterricht must not be null");
        checkNotFoundWithId(repository.save(unterricht), unterricht.getId());
    }

    @Override
    public List<Unterricht> getAll() {
        return repository.getAll();
    }
}

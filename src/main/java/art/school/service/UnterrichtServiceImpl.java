package art.school.service;

import art.school.entity.Unterricht;
import art.school.repository.UnterrichtRepository;
import art.school.to.RequestUnterrichtTo;
import art.school.to.UnterrichtTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.Collectors;

import static art.school.util.DateUtil.parseStringsToLocalDateTime;
import static art.school.util.ValidationUtil.*;

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
        if (u != null) {
            u.setBezahlt(!u.isBezahlt());
        }
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
        u.setDatum(parseStringsToLocalDateTime(unterrichtTo.getDatum(), unterrichtTo.getZeit()));
        u.setBezahlt(unterrichtTo.isBezahlt());
        u.setNotiz(unterrichtTo.getNotiz());
        assureIdConsistent(u, u.getId());
        create(u, unterrichtTo.getKind() != null ? unterrichtTo.getKind() : u.getUser().getId(),
                unterrichtTo.getZahlung() != null ? unterrichtTo.getZahlung() : u.getZahlung().getId());

    }

    @Override
    @Transactional
    public RequestUnterrichtTo createRequestUnterrichtTo(int id) {
        return new RequestUnterrichtTo(get(id));
    }

    @Override
    @Transactional
    public List<UnterrichtTo> getAllTos() {
        return getAll()
                .stream()
                .map(UnterrichtTo::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getYears() {
        return repository.getYears();
    }

    @Override
    public List<Unterricht> getAllByYear(int year) {
        return repository.getAllByYear(year);
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

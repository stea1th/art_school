package art.school.repository.datajpa;

import art.school.entity.Unterricht;
import art.school.entity.Users;
import art.school.entity.Zahlung;
import art.school.repository.UnterrichtRepository;
import art.school.repository.UserRepository;
import art.school.repository.ZahlungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class UnterrichtRepositoryImpl implements UnterrichtRepository {
    private static final Sort SORT_BY_DATE = new Sort(Sort.Direction.DESC, "datum");


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ZahlungRepository zahlungRepository;

    @Autowired
    private CrudUnterrichtRepository repository;

    @Override
    @Transactional
    public Unterricht save(Unterricht unterricht, Integer... ids) {
        Users kind = userRepository.get(ids[0]);
        Zahlung zahlung = zahlungRepository.get(ids[1]);
        if (kind == null || zahlung == null) {
            return null;
        }
        unterricht.setUser(kind);
        unterricht.setZahlung(zahlung);
        return repository.save(unterricht);
    }

    @Override
    @Transactional
    public Unterricht save(Unterricht unterricht) {
        return repository.save(unterricht);
    }

    @Override
    public boolean delete(int id) {
        return repository.delete(id) != 0;
    }

    @Override
    public Unterricht get(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Unterricht> getAll() {
        return repository.findAll(SORT_BY_DATE);
    }

    public List<String> getYears() {
        return repository.getYears();
    }

    @Override
    public List<Unterricht> getAllByYear(int year) {
        return repository.getAllByYear(year);
    }
}

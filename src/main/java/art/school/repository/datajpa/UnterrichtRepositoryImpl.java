package art.school.repository.datajpa;

import art.school.entity.Unterricht;
import art.school.repository.UnterrichtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UnterrichtRepositoryImpl implements UnterrichtRepository {
    private static final Sort SORT_BY_DATE = new Sort(Sort.Direction.DESC, "datum");

    @Autowired
    private CrudKindRepository kindRepository;

    @Autowired
    private CrudZahlungRepository zahlungRepository;

    @Autowired
    private CrudUnterrichtRepository repository;

    @Override
    @Transactional
    public Unterricht save(Unterricht unterricht, Integer... ids) {

        unterricht.setKind(kindRepository.getOne(ids[0]));
        unterricht.setZahlung(zahlungRepository.getOne(ids[1]));
        return repository.save(unterricht);
    }

    @Override
    public Unterricht save(Unterricht unterricht) {
        return null;
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
}

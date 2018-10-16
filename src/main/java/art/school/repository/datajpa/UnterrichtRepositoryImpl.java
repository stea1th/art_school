package art.school.repository.datajpa;

import art.school.entity.Kind;
import art.school.entity.Unterricht;
import art.school.entity.Zahlung;
import art.school.repository.KindRepository;
import art.school.repository.UnterrichtRepository;
import art.school.repository.ZahlungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UnterrichtRepositoryImpl implements UnterrichtRepository {
    private static final Sort SORT_BY_DATE = new Sort(Sort.Direction.DESC, "datum");

//    @Autowired
//    private CrudKindRepository kindRepository;
//
//    @Autowired
//    private CrudZahlungRepository zahlungRepository;
    @Autowired
    private KindRepository kindRepository;

    @Autowired
    private ZahlungRepository zahlungRepository;

    @Autowired
    private CrudUnterrichtRepository repository;

    @Override
    @Transactional
    public Unterricht save(Unterricht unterricht, Integer... ids) {
        Kind kind = kindRepository.get(ids[0]);
        Zahlung zahlung = zahlungRepository.get(ids[1]);
        if( kind == null || zahlung == null){
            return null;
        }
        unterricht.setKind(kind);
        unterricht.setZahlung(zahlung);
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
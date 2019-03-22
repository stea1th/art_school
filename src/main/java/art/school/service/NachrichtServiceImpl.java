package art.school.service;

import art.school.entity.Block;
import art.school.entity.Nachricht;
import art.school.entity.NachrichtUpdater;
import art.school.repository.BlockRepository;
import art.school.repository.NachrichtRepository;
import art.school.repository.NachrichtUpdaterRepository;
import art.school.to.NachrichtTo;
import art.school.util.TransformUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static art.school.util.DateUtil.formatDateToString;

@Service
public class NachrichtServiceImpl implements NachrichtService {

    @Autowired
    private NachrichtRepository repository;

    @Autowired
    private NachrichtUpdaterRepository nachrichtUpdaterRepository;

    @Autowired
    private BlockRepository blockRepository;


    @Override
    public List<Nachricht> getAllByThemaId(int id) {
        return repository.getAllByThemaId(id);
    }

    @Override
    public Page<Nachricht> getPageByThemaId(int id, Pageable pageable) {
        return repository.getPageByThemaId(id, pageable);
    }

    @Override
    public Nachricht create(Nachricht nachricht) {
        return repository.save(nachricht);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public Nachricht get(int id) {
        return repository.get(id);
    }

    @Override
    public void update(Nachricht nachricht) {
        repository.save(nachricht);
    }

    @Override
    public List<Nachricht> getAll() {
        return repository.getAll();
    }

    @Transactional
    public Nachricht createNachrichtWithUpdaters(Integer id, String action) {
        Nachricht nachricht = id == null? new Nachricht() :  get(id);
        List<NachrichtUpdater> updaters = nachricht.isNew()? new ArrayList<>() : nachricht.getUpdaters();
        updaters.add(nachrichtUpdaterRepository.save(new NachrichtTo(id).createUpdater(action)));
        nachricht.setUpdaters(updaters);
        return nachricht;
    }

    @Transactional
    public List<NachrichtTo> getAllTosByThema(int id, Pageable pageable){
        return getPageByThemaId(id, pageable)
                .stream()
//                .map(NachrichtTo::new)
                .map(i-> {
                    NachrichtTo n = new NachrichtTo(i);
                    Block b = blockRepository.getLatestByUserId(i.getUser().getId());
                    if(b != null){
                        n.setBanned(formatDateToString(b.getDatum()));
                    }
                    return n;
                })
                .collect(Collectors.toCollection(LinkedList::new));
    }

    @Transactional
    public List<NachrichtTo> getAllTosByThema(int id){
        return TransformUtil.transformTo(getAllByThemaId(id), NachrichtTo.class);
    }

    @Transactional
    public List<NachrichtTo> getAllTos(){
        return TransformUtil.transformTo(getAll(), NachrichtTo.class);
    }

    public Long count(){
        return repository.count();
    }

    @Override
    @Transactional
    public NachrichtTo getTo(int id) {
        return new NachrichtTo(get(id));
    }
}

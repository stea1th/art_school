package art.school.service;

import art.school.entity.Block;
import art.school.entity.Nachricht;
import art.school.entity.NachrichtUpdater;
import art.school.helper.NachrichtHelper;
import art.school.repository.BlockRepository;
import art.school.repository.NachrichtRepository;
import art.school.repository.NachrichtUpdaterRepository;
import art.school.to.NachrichtTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static art.school.util.DateUtil.formatDateTimeToString;

@Service
public class NachrichtServiceImpl implements NachrichtService {

    @Autowired
    private NachrichtRepository repository;

    @Autowired
    private NachrichtUpdaterRepository nachrichtUpdaterRepository;

    @Autowired
    private BlockRepository blockRepository;

    @Autowired
    private NachrichtHelper nachrichtHelper;


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
        if (id != null) {
            Nachricht nachricht = get(id);
            List<NachrichtUpdater> updaters = nachricht.getUpdaters();
            updaters.add(nachrichtUpdaterRepository.save(nachrichtHelper.createUpdater(id, action)));
            nachricht.setUpdaters(updaters);
            return nachricht;
        }
        return null;
    }

    @Transactional
    public List<NachrichtTo> getAllTosByThema(int id, Pageable pageable) {
        return convertInToList(getPageByThemaId(id, pageable));
    }

    @Transactional
    public Map<List<NachrichtTo>, Page<Nachricht>> getAllTosAsMap(int id, Pageable pageable) {
        Page<Nachricht> page = getPageByThemaId(id, pageable);
        return Collections.singletonMap(convertInToList(page), page);
    }

    @Override
    public NachrichtTo getTo(int id, int page, boolean reload) {
        return nachrichtHelper.createTo(id, page, reload);
    }

    @Transactional
    public List<NachrichtTo> getAllTosByThema(int id) {
        return transformTos(getAllByThemaId(id));
    }

    @Transactional
    public List<NachrichtTo> getAllTos() {
        return transformTos(getAll());
    }

    public Long count() {
        return repository.count();
    }

    @Override
    @Transactional
    public NachrichtTo getTo(int id) {
        return nachrichtHelper.createTo(get(id));
    }

    private List<NachrichtTo> convertInToList(Page<Nachricht> page) {
        return page.stream()
                .map(i -> {
                    NachrichtTo n = nachrichtHelper.createTo(i);
                    Block b = blockRepository.getLatestByUserId(i.getUser().getId());
                    if (b != null) {
                        n.setBanned(formatDateTimeToString(b.getDatum()));
                    }
                    return n;
                })
                .collect(Collectors.toList());
    }

    private List<NachrichtTo> transformTos(List<Nachricht> list) {
        return list.stream().map(i -> nachrichtHelper.createTo(i))
                .collect(Collectors.toList());
    }
}

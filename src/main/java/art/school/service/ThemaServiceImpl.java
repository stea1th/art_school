package art.school.service;

import art.school.entity.Nachricht;
import art.school.entity.Thema;
import art.school.helper.NachrichtHelper;
import art.school.helper.ThemaHelper;
import art.school.repository.ThemaRepository;
import art.school.to.ThemaTo;
import art.school.web.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class ThemaServiceImpl implements ThemaService {

    @Autowired
    private ThemaRepository repository;

    @Autowired
    private UserService userService;

    @Autowired
    private NachrichtService nachrichtService;

    @Autowired
    private ThemaHelper themaHelper;

    @Autowired
    private NachrichtHelper nachrichtHelper;

    @Override
    public Thema create(Thema thema) {
        return repository.save(thema);
    }

    @Override
    @Transactional
    public Thema create(String title, String message) {
        Thema thema = create(themaHelper.createThema(title));
        Nachricht nachricht = nachrichtHelper.createNachricht(message);
        nachricht.setUser(userService.get(SecurityUtil.getAuthId()));
        nachricht.setThema(thema);
        nachrichtService.create(nachricht);
        return thema;
    }

    @Override
    @Transactional
    public int toggle(int id) {
        Thema t = get(id);
        t.setAktiv(!t.isAktiv());
        t.setUser(t.getUser() == null ? userService.get(SecurityUtil.getAuthId()) : null);
        return getAll().indexOf(create(t)) / 10;
    }

    @Override
    @Transactional
    public void countClicks(int id) {
        Thema t = get(id);
        t.setViews(t.getViews() + 1);
    }

    @Override
    @Transactional
    public void deleteAll(Integer[] arr) {
        Arrays.stream(arr).forEach(this::delete);
    }

    @Override
    @Transactional
    public void updateTitle(int id, String text) {
        Thema t = get(id);
        if(t != null){
            t.setTitel(text);
        }
    }

    @Override
    @Transactional
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    @Transactional
    public Thema get(int id) {
        return repository.get(id);
    }

    @Override
    public void update(Thema thema) {
        repository.save(thema);
    }

    @Override
    @Transactional
    public List<Thema> getAll() {
        return repository.getAll();
    }

    @Override
    @Transactional
    public Page<Thema> getAll(Pageable pageable) {
        return repository.getAll(pageable);
    }

    @Transactional
    public Map<List<ThemaTo>, Page<Thema>> getAllTosAsMap(Pageable pageable) {
        Page<Thema> page = getAll(pageable);
        return Collections.singletonMap(themaHelper.transformTos(page.getContent()), page);
    }

    @Override
    @Transactional
    public List<ThemaTo> getAllTos() {
        return themaHelper.transformTos(getAll());
    }

    @Override
    @Transactional
    public List<ThemaTo> getAllTos(Pageable pageable) {
        return themaHelper.transformTos(getAll(pageable).getContent());
    }

    @Transactional
    public ThemaTo getTo(int id) {
        return themaHelper.createTo(get(id));
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    @Transactional
    public void attach(int id) {
        Thema t = get(id);
        t.setGepinnt(!t.isGepinnt());
    }
}

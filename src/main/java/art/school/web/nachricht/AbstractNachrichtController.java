package art.school.web.nachricht;

import art.school.entity.Nachricht;
import art.school.service.NachrichtService;
import art.school.service.ThemaService;
import art.school.service.UserService;
import art.school.to.NachrichtTo;
import art.school.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

import static art.school.util.ValidationUtil.assureIdConsistent;

public class AbstractNachrichtController {

    @Autowired
    private NachrichtService nachrichtService;

    @Autowired
    ThemaService themaService;

    @Autowired
    UserService userService;

    @Autowired
    Messages message;

    public List<Nachricht> getAllByThemaId(int themaId) {
        return nachrichtService.getAllByThemaId(themaId);
    }

    public Page<Nachricht> getPageByThemaId(int id, Pageable pageable) {
        return nachrichtService.getPageByThemaId(id, pageable);
    }

    public Nachricht get(int id) {
        return nachrichtService.get(id);
    }

    public Nachricht create(Nachricht nachricht) {
        return nachrichtService.create(nachricht);
    }

    public Nachricht createNachrichtWithUpdaters(Integer id, String action) {
        return nachrichtService.createNachrichtWithUpdaters(id, action);
    }

    public List<NachrichtTo> getAllTosByThema(int id, Pageable pageable) {
        return nachrichtService.getAllTosByThema(id, pageable);
    }


    public List<NachrichtTo> getAllTosByThema(int id) {
        return nachrichtService.getAllTosByThema(id);
    }

    public List<NachrichtTo> getAllTos() {
        return nachrichtService.getAllTos();
    }

    public Long count() {
        return nachrichtService.count();
    }

    public void delete(int id) {
        nachrichtService.delete(id);
    }

    public void update(Nachricht n, int id) {
        assureIdConsistent(n, id);
        nachrichtService.update(n);
    }

    public NachrichtTo getTo(int id) {
        return nachrichtService.getTo(id);
    }

    public NachrichtTo getTo(int id, int page, boolean reload) {
        return nachrichtService.getTo(id, page, reload);
    }

    public Map<List<NachrichtTo>, Page<Nachricht>> getAllTosAsMap(int id, Pageable pageable) {
        return nachrichtService.getAllTosAsMap(id, pageable);
    }
}

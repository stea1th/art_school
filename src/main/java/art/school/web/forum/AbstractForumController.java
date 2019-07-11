package art.school.web.forum;

import art.school.entity.Thema;
import art.school.service.ThemaService;
import art.school.service.UserService;
import art.school.to.ThemaTo;
import art.school.util.Messages;
import art.school.web.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

import static art.school.util.ValidationUtil.assureIdConsistent;

public abstract class AbstractForumController {

    @Autowired
    private ThemaService themaService;

    @Autowired
    private UserService userService;

    @Autowired
    Messages message;

    public List<Thema> getAll() {
        return themaService.getAll();
    }

    public Thema get(int id) {
        return themaService.get(id);
    }

    public ThemaTo getTo(int id) {
        return themaService.getTo(id);
    }

    public Page<Thema> getAll(Pageable pageable) {
        return themaService.getAll(pageable);
    }

    public Thema save(String title, String message) {
        return themaService.create(title, message);
    }

    void countClicks(int id) {
        themaService.countClicks(id);
    }

    void attach(int id) {
        themaService.attach(id);
    }

    public int toggle(int id) {
        return themaService.toggle(id);
    }

    public Map<List<ThemaTo>, Page<Thema>> getAllTosAsMap(Pageable pageable) {
        return themaService.getAllTosAsMap(pageable);
    }

    public List<ThemaTo> getAllTos(Pageable pageable) {
        return themaService.getAllTos(pageable);
    }

    public List<ThemaTo> getAllTos() {
        return themaService.getAllTos();
    }

    public void delete(int id) {
        themaService.delete(id);
    }

    public Thema create(Thema t) {
        return themaService.create(t);
    }

    public void update(Thema t, int id) {
        assureIdConsistent(t, id);
        themaService.update(t);
    }

    public long count() {
        return themaService.count();
    }

    public boolean isThisUserBanned() {
        return userService.isUserBanned(SecurityUtil.getAuthId());
    }

    protected void deleteAllThemes(Integer[] arr) {
        themaService.deleteAll(arr);
    }

    public void updateTitle(int id, String text) {
        themaService.updateTitle(id, text);
    }
}

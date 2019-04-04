package art.school.web.forum;

import art.school.entity.Nachricht;
import art.school.entity.Thema;
import art.school.service.NachrichtService;
import art.school.service.ThemaService;
import art.school.service.UserService;
import art.school.to.ThemaTo;
import art.school.web.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static art.school.util.ValidationUtil.assureIdConsistent;

public abstract class AbstractForumController {

    @Autowired
    private ThemaService themaService;

    @Autowired
    private NachrichtService nachrichtService;

    @Autowired
    private UserService userService;

    public List<Thema> getAll(){
        return themaService.getAll();
    }

    public Thema get(int id) {
        return themaService.get(id);
    }

    public ThemaTo getTo(int id) {
        return themaService.getTo(id);
    }

    public Page<Thema> getAll(Pageable pageable){
        return themaService.getAll(pageable);
    }

    public Thema save(String title, String message) {
        Thema thema = themaService.create(new Thema(title));
        Nachricht nachricht = new Nachricht(message);
        nachricht.setUser(userService.get(SecurityUtil.getAuthId()));
        nachricht.setThema(thema);
        nachrichtService.create(nachricht);
        return thema;
    }

    void countClicks(int id){
        Thema t =  get(id);
        t.setViews(t.getViews()+1);
        themaService.create(t);
    }

    void attach(int id){
        themaService.attach(id);
    }

    public int toggle(int id){

        Thema t = get(id);
        t.setAktiv(!t.isAktiv());
        t.setUser(t.getUser() == null? userService.get(SecurityUtil.getAuthId()) : null);
        return themaService.getAll().indexOf(themaService.create(t)) / 10;
    }

    public List<ThemaTo> getAllTos(Pageable pageable){
        return themaService.getAllTos(pageable);
    }

    public List<ThemaTo> getAllTos(){
        return themaService.getAllTos();
    }

    public void delete(int id){
        themaService.delete(id);
    }

    public Thema create(Thema t){
        return themaService.create(t);
    }

    public void update(Thema t, int id){
        assureIdConsistent(t, id);
        themaService.update(t);
    }

    public long count(){
        return themaService.count();
    }

    public boolean isThisUserBanned(){
        return userService.isUserBanned(SecurityUtil.getAuthId());
    }
}

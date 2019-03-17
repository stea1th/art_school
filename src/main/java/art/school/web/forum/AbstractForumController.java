package art.school.web.forum;

import art.school.entity.Nachricht;
import art.school.entity.Thema;
import art.school.service.NachrichtService;
import art.school.service.ThemaService;
import art.school.service.UserService;
import art.school.web.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

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

    public int toggle(int id){
        Thema t = get(id);
        t.setAktiv(!t.isAktiv());
        t.setUser(t.getUser() == null? userService.get(SecurityUtil.getAuthId()) : null);
        t = themaService.create(t);
        List<Thema> list = themaService.getAll();
        System.out.println(t.getId());
        System.out.println("===================================================" + list.size());
        list.forEach(i-> System.out.println(i.getId()));
        System.out.println("=====================================================" + list.contains(t));
        System.out.println("=====================================================" + list.indexOf(t));

        System.out.println("==========================================================" + list.indexOf(t) / 10);
        return list.indexOf(t) / 10;
    }
}

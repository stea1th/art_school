package art.school.web.kind;


import art.school.entity.Kind;
import art.school.service.KindService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static art.school.util.ValidationUtil.assureIdConsistent;
import static art.school.util.ValidationUtil.checkNew;


@Slf4j
public abstract class AbstractKindController {

    @Autowired
    KindService kindService;

    public Kind get(int id){
        log.info("get Kind {}", id);
        return kindService.get(id);
    }

    public Kind create(Kind kind){
        log.info("create {}", kind);
        checkNew(kind);
        return kindService.create(kind);
    }

    public void delete(int id){
        log.info("delete Kind {}", id);
        kindService.delete(id);
    }

    public void toggleAktiv(int id){
        log.info("toggle Kind {} Status", id);
        kindService.toggleAktiv(id);
    }

    public void update(Kind kind, int id){
        log.info("update {} with id={}",kind, id);
        assureIdConsistent(kind, id);
        kindService.update(kind);
    }

    public List<Kind> getAll(){
        log.info("getAll Kinder");
        return kindService.getAll();
    }
}

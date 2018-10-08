package art.school.web.kind;


import art.school.entity.Kind;
import art.school.service.KindService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.validation.constraints.Size;
import java.util.List;

import static art.school.util.ValidationUtil.assureIdConsistent;
import static art.school.util.ValidationUtil.checkNew;

@Controller
@Slf4j
public class KindController {

    @Autowired
    KindService kindService;

    public Kind get(int id){
        log.info("get {}", id);
        return kindService.get(id);
    }

    public Kind create(Kind kind){
        log.info("create {}", kind);
        checkNew(kind);
        return kindService.create(kind);
    }

    public void delete(int id){
        log.info("delete {}", id);
        kindService.delete(id);
    }

    public void toggleAktiv(int id){
        log.info("toggleAktiv {}", id);
        kindService.toggleAktiv(id);
    }

    public void update(Kind kind, int id){
        log.info("update {} with id={}",kind, id);
        assureIdConsistent(kind, id);
        kindService.update(kind);
    }

    public List<Kind> getAll(){
        log.info("getAll");
        return kindService.getAll();
    }
}

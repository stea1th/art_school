package art.school.web.unterricht;

import art.school.entity.Unterricht;
import art.school.service.UnterrichtService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

import static art.school.util.ValidationUtil.assureIdConsistent;
import static art.school.util.ValidationUtil.checkNew;

@Controller
@Slf4j
public class UnterrichtController {

    @Autowired
    UnterrichtService unterrichtService;

    public Unterricht get(int id){
        log.info("get Unterricht {}", id);
        return unterrichtService.get(id);
    }

    public Unterricht create(Unterricht unterricht, int k_id, int z_id){
        log.info("create {} for Kind {} and Zahlung {}", unterricht, k_id, z_id);
        checkNew(unterricht);
        return unterrichtService.create(unterricht, k_id, z_id );
    }

    public void delete(int id){
        log.info("delete Unterricht {}", id);
        unterrichtService.delete(id);
    }

    public void toggleBezahlt(int id){
        log.info("toggle Unterricht {} Status", id);
        unterrichtService.toggleBezahlt(id);
    }

    public void update(Unterricht unterricht, int id){
        log.info("update {} with id={}", unterricht, id);
        assureIdConsistent(unterricht, id);
        unterrichtService.update(unterricht);
    }

    public List<Unterricht> getAll(){
        log.info("getAll Unterrichts");
        return unterrichtService.getAll();
    }
}

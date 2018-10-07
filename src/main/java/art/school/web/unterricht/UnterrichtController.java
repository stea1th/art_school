package art.school.web.unterricht;

import art.school.entity.Unterricht;
import art.school.service.UnterrichtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

import static art.school.util.ValidationUtil.assureIdConsistent;
import static art.school.util.ValidationUtil.checkNew;

@Controller
public class UnterrichtController {

    @Autowired
    UnterrichtService unterrichtService;

    public Unterricht get(int id){
        return unterrichtService.get(id);
    }

    public Unterricht create(Unterricht unterricht, int k_id, int z_id){
        checkNew(unterricht);
        return unterrichtService.create(unterricht, k_id, z_id );
    }

    public void delete(int id){
        unterrichtService.delete(id);
    }

    public void toggleBezahlt(int id){
        unterrichtService.toggleBezahlt(id);
    }

    public void update(Unterricht unterricht, int id){
        assureIdConsistent(unterricht, id);
        unterrichtService.update(unterricht);
    }

    public List<Unterricht> getAll(){
        return unterrichtService.getAll();
    }
}

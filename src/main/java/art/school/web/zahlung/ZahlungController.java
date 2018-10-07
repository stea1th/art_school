package art.school.web.zahlung;

import art.school.entity.Zahlung;
import art.school.service.ZahlungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

import static art.school.util.ValidationUtil.assureIdConsistent;
import static art.school.util.ValidationUtil.checkNew;

@Controller
public class ZahlungController {

    @Autowired
    ZahlungService zahlungService;

    public Zahlung get(int id){
        return zahlungService.get(id);
    }

    public Zahlung create(Zahlung zahlung){
        checkNew(zahlung);
        return zahlungService.create(zahlung);
    }

    public void delete(int id){
        zahlungService.delete(id);
    }


    public void update(Zahlung zahlung, int id){
        assureIdConsistent(zahlung, id);
        zahlungService.update(zahlung);
    }

    public List<Zahlung> getAll(){
        return zahlungService.getAll();
    }

}

package art.school.web.zahlung;

import art.school.entity.Zahlung;
import art.school.service.ZahlungService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static art.school.util.ValidationUtil.assureIdConsistent;
import static art.school.util.ValidationUtil.checkNew;


@Slf4j
public abstract class AbstractZahlungController {

    @Autowired
    ZahlungService zahlungService;

    public Zahlung get(int id){
        log.info("get Zahlung {}", id);
        return zahlungService.get(id);
    }

    public Zahlung create(Zahlung zahlung){
        log.info("create Zahlung {}", zahlung);
        checkNew(zahlung);
        return zahlungService.create(zahlung);
    }

    public void delete(int id){
        log.info("delete Zahlung {}", id);
        zahlungService.delete(id);
    }

    public void update(Zahlung zahlung, int id){
        log.info("update {} with id={}", zahlung, id);
        assureIdConsistent(zahlung, id);
        zahlungService.update(zahlung);
    }

    public List<Zahlung> getAll(){
        log.info("getAll Zahlungen");
        return zahlungService.getAll();
    }

    public void toggleAktiv(int id){
        log.info("toggle Zahlung {} Status", id);
        zahlungService.toggleAktiv(id);
    }

}

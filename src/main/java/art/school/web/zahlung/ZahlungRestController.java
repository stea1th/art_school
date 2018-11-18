package art.school.web.zahlung;

import art.school.entity.Zahlung;
import art.school.to.ZahlungTo;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

import static art.school.util.TransformUtil.transformTo;
import static art.school.util.TransformUtil.transformToFilterAktiv;

@RestController
@RequestMapping("/zahlung")
public class ZahlungRestController extends AbstractZahlungController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ZahlungTo> all() {
        return transformTo(super.getAll(), ZahlungTo.class);
    }

    @PostMapping(value = "/toggle/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public ResponseEntity<String> toggle(@PathVariable("id") int id) {
        super.toggleAktiv(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/filter/aktiv", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ZahlungTo> onlyAktiv() {
        return transformToFilterAktiv(super.getAll(), ZahlungTo.class);
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public ResponseEntity<String> saveOrUpdate(ZahlungTo z){
//        System.out.println(z);
        zahlungService.create(new Zahlung(z));
//        System.out.println(z.getDauer().split("\\.")[0]);
//        String newDauer = z.getDauer().split("\\.")[0];
//        System.out.println(newDauer);
//        Zahlung zahlung = new Zahlung();
//        zahlung.setName(z.getName());
//        zahlung.setPreis(z.getPreis());
//        zahlung.setDauer(LocalTime.ofSecondOfDay(Long.valueOf(z.getDauer().split(".")[0])*60));
//        System.out.println(zahlung);
//        System.out.println(z);
//    public void saveOrUpdate(@RequestParam(name="name") String name){
//        System.out.println(name);
        return new ResponseEntity<>(HttpStatus.OK);

    }


}

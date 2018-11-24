package art.school.web.zahlung;

import art.school.entity.Zahlung;
import art.school.to.ZahlungTo;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        zahlungService.create(new Zahlung(z));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id){
        super.delete(id);
    }
}

package art.school.web.zahlung;

import art.school.entity.Zahlung;
import art.school.to.ZahlungTo;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.temporal.ChronoField;
import java.util.*;

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
    @SuppressWarnings("unchecked")
    public ResponseEntity saveOrUpdate(ZahlungTo z, BindingResult result) {

        HashMap<String, String> response = new LinkedHashMap<>();
        Zahlung zahlung = new Zahlung(z);
        String message = null;
        try {
            if (zahlung.isNew()) {
                super.create(zahlung);
                message = "Save";
            } else {
                super.update(zahlung, zahlung.getId());
                message = "Update";
            }
        }catch(Exception e){
            return new ResponseEntity(e.getLocalizedMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
        response.put(message, z.getName());
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id) {
        super.delete(id);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ZahlungTo getZahlung(@PathVariable("id") int id) {
        Zahlung z = super.get(id);
        return new ZahlungTo(z.getId(), z.getName(), z.getPreis(),
                String.valueOf(z.getDauer().get(ChronoField.MINUTE_OF_DAY)), z.isAktiv());

    }
}

package art.school.web.zahlung;

import art.school.entity.Zahlung;
import art.school.to.ZahlungTo;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/zahlung")
@Secured("ROLE_MODERATOR")
public class ZahlungRestController extends AbstractZahlungController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ZahlungTo> all() {
        return super.getAllTos();
    }

    @PostMapping(value = "/toggle/{id}")
    public ResponseEntity<Boolean> toggle(@PathVariable("id") int id) {
        return new ResponseEntity<>(super.toggleAktiv(id), HttpStatus.OK);
    }

    @GetMapping(value = "/filter/aktiv", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ZahlungTo> onlyAktiv() {
        return super.onlyAktiv();
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @SuppressWarnings("unchecked")
    public ResponseEntity saveOrUpdate(ZahlungTo z) {

        Map<String, String> response = new LinkedHashMap<>();
        Zahlung zahlung = new Zahlung(z);
        String message;
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
    public ZahlungTo getTo(@PathVariable("id") int id) {
        return super.getTo(id);

    }
}

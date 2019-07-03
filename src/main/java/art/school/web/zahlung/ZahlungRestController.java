package art.school.web.zahlung;

import art.school.to.ZahlungTo;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

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
    public ResponseEntity saveOrUpdate(ZahlungTo to) {

        createWithTo(to);
        return new ResponseEntity<>(Collections.singletonMap(to.isNew() ? "Save" : "Update", to.getName()), HttpStatus.OK);
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

package art.school.web.zahlung;

import art.school.to.ZahlungTo;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static art.school.util.TransformUtil.transformTo;

@RestController
@RequestMapping("/zahlung")
public class ZahlungRestController extends AbstractZahlungController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ZahlungTo> all() {
        return transformTo(super.getAll(), ZahlungTo.class);
    }

    @PostMapping(value="/toggle/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public ResponseEntity<String> toggle(@PathVariable("id") int id){
        super.toggleAktiv(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

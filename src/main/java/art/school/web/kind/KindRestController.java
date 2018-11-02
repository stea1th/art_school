package art.school.web.kind;

import art.school.to.KindTo;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/kind")
public class KindRestController extends AbstractKindController {


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<KindTo> all() {
        return super.getAll().stream().map(KindTo::new)
                .collect(Collectors.toList());
        }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id) {
        super.delete(id);
    }

    @PostMapping(value="/toggle/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public ResponseEntity<String> toggle(@PathVariable("id") int id){
        super.toggleAktiv(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

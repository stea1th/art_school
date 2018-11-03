package art.school.web.kind;

import art.school.to.KindTo;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static art.school.util.TransformUtil.transformTo;

@RestController
@RequestMapping(value = "/kind")
public class KindRestController extends AbstractKindController {


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<KindTo> all() {
        return transformTo(super.getAll(), KindTo.class);
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

    @GetMapping(value="/filter/aktiv", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<KindTo> onlyAktiv(){
//        return transformToFilterAktiv(super.getAll(), KindTo.class);
        return transformTo(super.getAll(), KindTo.class)
                .stream()
                .filter(KindTo::isAktiv)
                .collect(Collectors.toList());
    }
}

package art.school.web.kind;

import art.school.entity.Kind;
import art.school.to.KindTo;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public KindTo getKind(@PathVariable("id") int id){
        return new KindTo(super.get(id));
    }

    @PostMapping(value="/toggle/{id}")
    public ResponseEntity<String> toggle(@PathVariable("id") int id){
        super.toggleAktiv(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value="/filter/aktiv", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<KindTo> onlyAktiv(){
        return transformTo(super.getAll(), KindTo.class)
                .stream()
                .filter(KindTo::isAktiv)
                .collect(Collectors.toList());
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @SuppressWarnings("unchecked")
    public ResponseEntity saveOrUpdate(KindTo z){
        Map<String, String> response = new LinkedHashMap<>();
        Kind kind = new Kind(z);
        String message;
        if (kind.isNew()) {
            super.create(kind);
            message = "Save";
        } else {
            super.update(kind, kind.getId());
            message = "Update";
        }
        response.put(message, z.getName());
        return new ResponseEntity(response, HttpStatus.OK);
    }
}

package art.school.web.user;

import art.school.entity.Users;
import art.school.to.UserTo;
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
public class KindRestController extends AbstractUserController {


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserTo> all() {
        return transformTo(super.getAllKinds(), UserTo.class);
        }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id) {
        super.delete(id);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserTo getKind(@PathVariable("id") int id){
        return new UserTo(super.get(id));
    }

    @PostMapping(value="/toggle/{id}")
    public ResponseEntity<String> toggle(@PathVariable("id") int id){
        super.toggleAktiv(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value="/filter/aktiv", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserTo> onlyAktiv(){
        return transformTo(super.getAllKinds(), UserTo.class)
                .stream()
                .filter(UserTo::getAktiv)
                .collect(Collectors.toList());
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @SuppressWarnings("unchecked")
    public ResponseEntity saveOrUpdate(UserTo z){
        Map<String, String> response = new LinkedHashMap<>();
        Users kind = z.isNew()? z.createUser() : z.updateUser(super.get(z.getId()));
        String message = z.isNew()? "Save" : "Update";
        super.create(kind);
        response.put(message, z.getName());
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
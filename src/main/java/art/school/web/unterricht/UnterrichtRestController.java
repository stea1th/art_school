package art.school.web.unterricht;


import art.school.to.RequestUnterrichtTo;
import art.school.to.UnterrichtTo;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/unterricht")
@Secured("ROLE_MODERATOR")
public class UnterrichtRestController extends AbstractUnterrichtController {

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public ResponseEntity<String> createOrUpdate(RequestUnterrichtTo unterrichtTo) {
        if (unterrichtTo.isNew()) {
            super.create(unterrichtTo);
        } else {
            super.update(unterrichtTo);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UnterrichtTo> all() {
        return super.getAllTos();
    }

    @PostMapping(value = "/update/ondrop/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public ResponseEntity<String> updateOnDragAndDrop(
            @PathVariable("id") int id,
            @RequestParam(value = "date") String date) {

        super.updateOnDrop(id, date);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/get/{id}")
    public RequestUnterrichtTo get(@PathVariable(name = "id") Integer id) {
        return super.createRequestUnterrichtTo(id);
    }

    @PostMapping(value = "/delete/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id) {
        super.delete(id);
    }
}

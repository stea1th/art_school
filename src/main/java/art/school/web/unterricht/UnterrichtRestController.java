package art.school.web.unterricht;


import art.school.entity.Unterricht;
import art.school.to.RequestUnterrichtTo;
import art.school.to.UnterrichtTo;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/unterricht")
public class UnterrichtRestController extends AbstractUnterrichtController {

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public ResponseEntity<String> createOrUpdate(RequestUnterrichtTo unterrichtTo) {
        System.out.println(unterrichtTo.toString());
        if (unterrichtTo.isNew()) {
            super.create(unterrichtTo);
        } else {
            super.update(unterrichtTo);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UnterrichtTo> all() {
        List<UnterrichtTo> list = new ArrayList<>();
        super.getAll().forEach(i -> list.add(new UnterrichtTo(i.getId(), i.getKind().getName(),
                i.getDatum().truncatedTo(ChronoUnit.SECONDS).toString(),
                i.getDatum().truncatedTo(ChronoUnit.SECONDS).plusMinutes(i.getZahlung().getDauer().getLong(ChronoField.MINUTE_OF_DAY)).toString(), i.getNotiz(),
                !i.getKind().isAktiv() ? "grey" : i.isBezahlt() ? "green" : "red")));
        return list;
    }

    @PostMapping(value = "/update/ondrop/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public ResponseEntity<String> updateOnDragAndDrop(
            @PathVariable("id") int id,
            @RequestParam(value = "date") String date) {
        super.updateOnDrop(id, date);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value ="/get/{id}")
    public RequestUnterrichtTo get(@PathVariable(name = "id") Integer id){
        Unterricht unterricht = unterrichtService.get(id);
        return new RequestUnterrichtTo(unterricht);
    }

    @PostMapping(value = "/delete/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id) {
        super.delete(id);
    }
}

package art.school.web.nachricht;

import art.school.entity.Nachricht;
import art.school.to.NachrichtTo;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/nachricht")
@Secured("ROLE_MODERATOR")
public class NachrichtRestController extends AbstractNachrichtController{

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<NachrichtTo> all() {
        return super.getAllTos();
    }

    @GetMapping(value = "/thema/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<NachrichtTo> allByThema(@PathVariable(name = "id")Integer id) {
        return super.getAllTosByThema(id);
    }

    @GetMapping(value = "/thema/{id}/onpage", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<NachrichtTo> allOnPage(@PathVariable(name = "id")Integer id,
                                       @RequestParam(name = "page") Integer page,
                                   @RequestParam(name = "size") Integer size){
        return super.getAllTosByThema(id, PageRequest.of(page, size));
    }

    @GetMapping(value = "/size")
    public Long countNachrichts(){
        return super.count();
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(name = "id") Integer id) {
        super.delete(id);
    }

    @PostMapping(value = "/create", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public Nachricht create(Nachricht n){
        return super.create(n);
    }

    @PutMapping(value="/{id}", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public void update(@PathVariable(name = "id") Integer id, Nachricht n){
        super.update(n, id);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public NachrichtTo get(@PathVariable(name = "id") Integer id){
        return super.getTo(id);
    }
}

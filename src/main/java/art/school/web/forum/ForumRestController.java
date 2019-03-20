package art.school.web.forum;

import art.school.entity.Thema;
import art.school.to.ThemaTo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/forum")
public class ForumRestController extends AbstractForumController{

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ThemaTo> all() {
        return super.getAllTos();
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(name = "id") Integer id) {
        super.delete(id);
    }

    @PostMapping(value = "/create", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public Thema create(Thema t){
        return super.create(t);
    }

    @PutMapping(value="/{id}", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public void update(@PathVariable(name = "id") Integer id, Thema t){
        super.update(t, id);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ThemaTo get(@PathVariable(name = "id") Integer id){
        return super.getTo(id);
    }

}

package art.school.web.forum;

import art.school.entity.Thema;
import art.school.to.ThemaTo;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/forum")
@Secured("ROLE_MODERATOR")
public class ForumRestController extends AbstractForumController{

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ThemaTo> all() {
        return super.getAllTos();
    }

    @GetMapping(value = "/onpage", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ThemaTo> allOnPage(@RequestParam(name = "page") Integer page,
                                   @RequestParam(name = "size") Integer size){
        return super.getAllTos(PageRequest.of(page, size));
    }

    @GetMapping(value = "/size")
    public Long countThemas(){
        return super.count();
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

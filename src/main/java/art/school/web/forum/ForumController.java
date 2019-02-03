package art.school.web.forum;

import art.school.entity.Nachricht;
import art.school.entity.Thema;
import art.school.to.ThemaTo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/forum")
public class ForumController extends AbstractForumController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ThemaTo> all(){
        return super.getAll()
                .stream()
                .map(ThemaTo::new)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/theme/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Nachricht> getAllNachrichts(@PathVariable(name = "id") Integer id){
        return super.get(id).getNachrichts();
    }


}

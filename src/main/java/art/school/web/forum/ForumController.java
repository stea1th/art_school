package art.school.web.forum;

import art.school.entity.Thema;
import art.school.to.ThemaTo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
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
        super.getAll()
                .stream()
                .sorted(Comparator.comparing( (Thema i) -> i.getNachrichts().get(i.getNachrichts().size() - 1).getDatum()).reversed())
                .map(ThemaTo::new)
                .forEach(System.out::println);
        return super.getAll()
                .stream()
                .sorted(Comparator.comparing( (Thema i) -> i.getNachrichts().get(i.getNachrichts().size() - 1).getDatum()).reversed())
                .map(ThemaTo::new)
                .collect(Collectors.toList());
    }


}

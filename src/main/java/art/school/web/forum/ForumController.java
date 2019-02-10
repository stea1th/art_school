package art.school.web.forum;

import art.school.to.ThemaTo;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/forum")
public class ForumController extends AbstractForumController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<ThemaTo> all(){
        return super.getAll()
                .stream()
                .map(ThemaTo::new)
                .collect(Collectors.toList());
    }
}

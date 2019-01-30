package art.school.web.forum;

import art.school.entity.Thema;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/forum")
public class ForumController extends AbstractForumController {

    @GetMapping
    public List<Thema> all(){
        return super.getAll();
    }


}

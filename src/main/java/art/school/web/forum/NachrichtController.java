package art.school.web.forum;

import art.school.entity.Thema;
import art.school.to.NachrichtTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/nachricht")
public class NachrichtController extends AbstractForumController {

    @GetMapping
    public String getAllNachrichts(Model model, @RequestParam(name = "id") Integer id) {
        Thema thema = super.get(id);
        model.addAttribute("title", thema.getTitel());
        model.addAttribute("list", thema.getNachrichts()
                .stream()
                .map(NachrichtTo::new)
                .collect(Collectors.toList()));
        return "nachricht";
    }
}

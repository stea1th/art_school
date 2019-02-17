package art.school.web.forum;

import art.school.entity.Thema;
import art.school.to.NachrichtTo;
import art.school.web.SecurityUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedHashSet;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/nachricht")
public class NachrichtController extends AbstractForumController {

    @GetMapping
    public String getAllNachrichts(Model model, @RequestParam(name = "id") Integer id) {
        Thema thema = super.get(id);
        model.addAttribute("title", thema.getTitel());
        model.addAttribute("themaId", thema.getId());
        model.addAttribute("list", thema.getNachrichts()
                .stream()
                .map(NachrichtTo::new)
                .collect(Collectors.toCollection(LinkedHashSet::new)));
        model.addAttribute("current", SecurityUtil.getAuthId());
        return "nachricht";
    }

//    @PostMapping("/save")
//    public String createOrUpdate(){
//
//    }
}

package art.school.web.forum;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/nachricht")
public class NachrichtController extends AbstractForumController {

    @GetMapping
    public String getAllNachrichts(Model model, @RequestParam(name = "id") Integer id){
        model.addAttribute("list", super.get(id).getNachrichts());
        return "nachricht";
    }
}

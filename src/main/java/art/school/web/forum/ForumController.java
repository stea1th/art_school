package art.school.web.forum;

import art.school.entity.Thema;
import art.school.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

import static art.school.util.PaginationHelper.createTablePage;

@Controller
@RequestMapping(value = "/forum")
@Secured("ROLE_USER")
public class ForumController extends AbstractForumController {


    @Autowired
    private Messages messages;

    @GetMapping
    public String all(Model model,
                      @RequestParam(name = "select", required = false, defaultValue = "false") boolean select,
                      @RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
                      @RequestParam(name = "size", required = false, defaultValue = "10") int size){

        Pageable pageable = PageRequest.of(pageNumber, size);
        Page<Thema> page = super.getAll(pageable);
        model.addAttribute("list", super.getAllTos(pageable));
        model.addAttribute("link", "forum");
        model.addAttribute("title", messages.get("forum.title"));
        model.addAttribute("views", messages.get("forum.views"));
        model.addAttribute("answers", messages.get("forum.answers"));
        model.addAttribute("lastanswer", messages.get("forum.last"));
        model.addAttribute("isBanned", isThisUserBanned());
        createTablePage(model, page);

        return select ? "forum/fragment" : "forum/forum";
    }

    @PostMapping(value = "/save")
    @ResponseBody
    public Integer saveThema(@RequestParam(name="thema")String thema,
                             @RequestParam(name="message") String message) {

        return super.save(thema, message).getId();
    }

    @PostMapping(value="/views")
    @ResponseBody
    public void countClicks(@RequestParam(name="id")Integer id){
        super.countClicks(id);
    }

    @PostMapping(value="/toggle")
    @ResponseBody
    @Secured("ROLE_MODERATOR")
    public int toggleThema (@RequestParam(name="id") Integer id){
        return super.toggle(id);
    }

    @PostMapping(value="/attach")
    @ResponseBody
    @Secured("ROLE_MODERATOR")
    public void toggleAttach(@RequestParam(name="id") Integer id){
        super.attach(id);
    }

}

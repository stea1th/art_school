package art.school.web.forum;

import art.school.entity.Thema;
import art.school.to.DateTo;
import art.school.to.ThemaTo;
import art.school.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import static art.school.util.PaginationHelper.createTablePage;

@Controller
@RequestMapping(value = "/forum")
@Secured("ROLE_USER")
public class ForumController extends AbstractForumController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping
    public String all(Model model,
                      @RequestParam(name = "select", required = false, defaultValue = "false") boolean select,
                      @RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
                      @RequestParam(name = "size", required = false, defaultValue = "10") int size) {

        Locale locale = LocaleContextHolder.getLocale();
        Map.Entry<List<ThemaTo>, Page<Thema>> entry = super.getAllTosAsMap(PageRequest.of(pageNumber, size))
                .entrySet().iterator().next();

        model.addAttribute("list", entry.getKey()
                .stream().peek(i -> i.setLast(DateUtil.convertDateToToString(i.getDateTo(), messageSource, locale)))
                .collect(Collectors.toList()));

        model.addAttribute("link", "forum");
        model.addAttribute("title", messageSource.getMessage("forum.title", null, locale));
        model.addAttribute("views", messageSource.getMessage("forum.views", null, locale));
        model.addAttribute("answers", messageSource.getMessage("forum.answers", null, locale));
        model.addAttribute("lastanswer", messageSource.getMessage("forum.last", null, locale));
        model.addAttribute("isBanned", isThisUserBanned());
        createTablePage(model, entry.getValue());

        return select ? "forum/fragment" : "forum/forum";
    }

    @PostMapping(value = "/save")
    @ResponseBody
    public Integer saveThema(@RequestParam(name = "thema") String thema,
                             @RequestParam(name = "message") String message) {

        return super.save(thema, message).getId();
    }

    @PostMapping(value = "/views")
    @ResponseBody
    public void countClicks(@RequestParam(name = "id") Integer id) {
        super.countClicks(id);
    }

    @PostMapping(value = "/toggle")
    @ResponseBody
    @Secured("ROLE_MODERATOR")
    public int toggleThema(@RequestParam(name = "id") Integer id) {
        return super.toggle(id);
    }

    @PostMapping(value = "/attach")
    @ResponseBody
    @Secured("ROLE_MODERATOR")
    public void toggleAttach(@RequestParam(name = "id") Integer id) {
        super.attach(id);
    }

}

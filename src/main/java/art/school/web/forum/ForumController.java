package art.school.web.forum;

import art.school.entity.Thema;
import art.school.to.ThemaTo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

import static art.school.util.PaginationHelper.createTablePage;

@Controller
@RequestMapping(value = "/forum")
public class ForumController extends AbstractForumController {

    @GetMapping
    public String all(Model model,
                      @RequestParam(name = "select", required = false, defaultValue = "false") boolean select,
                      @RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
                      @RequestParam(name = "size", required = false, defaultValue = "10") int size){

        Page<Thema> page = super.getAll(PageRequest.of(pageNumber, size));
        model.addAttribute("list", super.getAllTos(PageRequest.of(pageNumber, size)));
        model.addAttribute("link", "forum");
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
    public int toggleThema (@RequestParam(name="id") Integer id){
        return super.toggle(id);
    }
}

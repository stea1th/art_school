package art.school.web.forum;

import art.school.entity.Thema;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static art.school.util.PaginationHelper.createTablePage;

@Controller
@RequestMapping(value = "/forum")
@Secured("ROLE_USER")
public class ForumController extends AbstractForumController {

    @GetMapping
    public String all(Model model,
                      @RequestParam(name = "select", required = false, defaultValue = "false") boolean select,
                      @RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
                      @RequestParam(name = "size", required = false, defaultValue = "10") int size){

        Pageable pageable = PageRequest.of(pageNumber, size);
        Page<Thema> page = super.getAll(pageable);
        model.addAttribute("list", super.getAllTos(pageable));
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
        System.out.println(id);
        return super.toggle(id);
    }
}

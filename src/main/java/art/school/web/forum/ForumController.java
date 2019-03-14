package art.school.web.forum;

import art.school.entity.Nachricht;
import art.school.entity.Thema;
import art.school.to.NachrichtTo;
import art.school.to.ThemaTo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.stream.Collectors;

import static art.school.util.PaginationHelper.createTablePage;

@Controller
@RequestMapping(value = "/forum")
public class ForumController extends AbstractForumController {

    @GetMapping
    public String all(Model model,
                      @RequestParam(name = "select", required = false, defaultValue = "false") boolean select,
                      @RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
                      @RequestParam(name = "sort", required = false, defaultValue = "gepinnt") String sort,
                      @RequestParam(name = "size", required = false, defaultValue = "2") int size){

        model.addAttribute("sort", sort);


        Page<Thema> page = super.getAll(PageRequest.of(pageNumber, size));
        model.addAttribute("list", page.stream()
                .map(ThemaTo::new)
                .collect(Collectors.toList()));
        model.addAttribute("link", "forum");
        createTablePage(model, page);

        return select ? "forum/fragment" : "forum/forum";
    }
}

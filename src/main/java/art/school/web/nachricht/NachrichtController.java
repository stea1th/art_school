package art.school.web.nachricht;

import art.school.entity.Nachricht;
import art.school.entity.NachrichtUpdater;
import art.school.entity.Thema;
import art.school.service.NachrichtUpdaterService;
import art.school.service.ThemaService;
import art.school.service.UserService;
import art.school.to.NachrichtTo;
import art.school.web.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static art.school.util.PaginationHelper.createTablePage;

@Controller
@RequestMapping(value = "/nachricht")
public class NachrichtController extends AbstractNachrichtController {

    @Autowired
    private ThemaService themaService;

    @Autowired
    private UserService userService;

    @Autowired
    private NachrichtUpdaterService nachrichtUpdaterService;

    @GetMapping
    public String getAllNachrichts(Model model, @RequestParam(name = "id") Integer id,
                                   @RequestParam(name = "select", required = false, defaultValue = "false") boolean select,
                                   @RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
                                   @RequestParam(name = "size", required = false, defaultValue = "10") int size) {
        Thema thema = themaService.get(id);

        model.addAttribute("title", thema.getTitel());
        model.addAttribute("themaId", id);
        if(!thema.isAktiv()){
            model.addAttribute("active", thema.isAktiv());
            model.addAttribute("closedBy", thema.getUser().getName());
        }

        Page<Nachricht> page = super.getPageByThemaId(id, PageRequest.of(pageNumber, size, Sort.by("datum", "id")));
        model.addAttribute("list", page.stream()
                .map(NachrichtTo::new)
                .collect(Collectors.toCollection(LinkedList::new)));
        model.addAttribute("link", "nachricht");
        createTablePage(model, page);

        return select ? "nachricht/fragment" : "nachricht/nachricht";
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    public NachrichtTo createOrUpdate(NachrichtTo nachrichtTo,
                                  @RequestParam(name="page") int pageNumber,
                                  @RequestParam(name="parentId", required = false) Integer parentId) {

        Nachricht nachricht;
        if (nachrichtTo.isNew()) {
            nachricht = new Nachricht();
            nachricht.setDatum(LocalDateTime.now());
            nachricht.setUser(userService.get(SecurityUtil.getAuthId()));
            if(parentId != null){
                nachricht.setParent(super.get(parentId));
            }
        } else {
            nachricht = createNachrichtWithUpdaters(nachrichtTo.getId(), "Изменил");
        }
        nachricht.setThema(themaService.get(nachrichtTo.getThemaId()));
        nachricht.setText(nachrichtTo.getText());
        super.create(nachricht);

        Pageable pageable = PageRequest.of(pageNumber, nachrichtTo.getSize());
        Page<Nachricht> page = super.getPageByThemaId(nachrichtTo.getThemaId(), pageable);

        return new NachrichtTo(nachricht.getId(), nachrichtTo.isNew()? page.getTotalPages() - 1 : pageNumber - 1, nachrichtTo.isNew());
    }

    @GetMapping(value = "/delete")
    @ResponseBody
    public String delete(@RequestParam(name = "id") Integer id) {
        Nachricht nachricht = createNachrichtWithUpdaters(id, "Удалил");
        String deleted = "<-- Удалено -->";
        nachricht.setText("<-- Deleted -->");
        super.create(nachricht);
        return deleted;
    }

    @GetMapping(value = "/text")
    public String getTextArea(Model model, @RequestParam(name="id", required = false)Integer id,
                              @RequestParam(name="answer", required = false, defaultValue = "false") boolean answer){
        if(id != null) {
            Nachricht nachricht = get(id);
            model.addAttribute("parentText", answer ? nachricht.getText() :
                    nachricht.getParent() != null ? nachricht.getParent().getText() : null);
            model.addAttribute("id", answer ? null : id);
            model.addAttribute("themaId", nachricht.getThema().getId());
            model.addAttribute("updateText", answer ? null : nachricht.getText());
        }
        return "nachricht/nachricht-form";
    }

    private Nachricht createNachrichtWithUpdaters(Integer id, String action) {
        Nachricht nachricht = id == null? new Nachricht() :  get(id);
        List<NachrichtUpdater> updaters = nachricht.isNew()? new ArrayList<>() : nachricht.getUpdaters();
        updaters.add(nachrichtUpdaterService.save(new NachrichtTo(id).createUpdater(action)));
        nachricht.setUpdaters(updaters);
        return nachricht;
    }
}

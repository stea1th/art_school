package art.school.web.nachricht;

import art.school.entity.Nachricht;
import art.school.entity.NachrichtUpdater;
import art.school.entity.Thema;
import art.school.service.NachrichtUpdaterService;
import art.school.service.ThemaService;
import art.school.service.UserService;
import art.school.to.NachrichtTo;
import art.school.util.PaginationHelper;
import art.school.util.TextFormatUtil;
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
import java.util.List;

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
                                   @RequestParam(name = "pageNumber", required = false, defaultValue = "0") Integer pageNumber,
                                   @RequestParam(name = "sort", required = false, defaultValue = "name") String sorting,
                                   @RequestParam(name = "direction", required = false, defaultValue = "true") boolean direction,
                                   @RequestParam(name = "step", required = false, defaultValue = "false") boolean step,
                                   @RequestParam(name = "size", required = false, defaultValue = "2") Integer sizing,
                                   @RequestParam(name = "select", required = false, defaultValue = "false") boolean select) {
        Thema thema = themaService.get(id);
        PaginationHelper helper = new PaginationHelper(pageNumber, sorting, direction, step, sizing, select, "nachricht");

        model.addAttribute("title", thema.getTitel());
        model.addAttribute("themaId", id);

        model.addAttribute("current", SecurityUtil.getAuthId());

        Pageable pageable = PageRequest.of(pageNumber, sizing, Sort.by("datum"));
        Page<Nachricht> page = super.getPageByThemaId(id, pageable);
        helper.createTablePage(model, page, super.getAllByThemaId(id).size());

        return select ? "nachricht/fragment" : "nachricht/nachricht";
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    public Integer createOrUpdate(NachrichtTo nachrichtTo) {

        System.out.println(nachrichtTo.getId());
        System.out.println(nachrichtTo.isNew());
        Nachricht nachricht;
        if (nachrichtTo.isNew()) {
            nachricht = new Nachricht();
            nachricht.setDatum(LocalDateTime.now());
        } else {
            nachricht = createNachrichtWithUpdaters(nachrichtTo.getId(), "Изменил");
        }
        nachricht.setThema(themaService.get(nachrichtTo.getThemaId()));
        nachricht.setUser(userService.get(SecurityUtil.getAuthId()));
        nachricht.setText(TextFormatUtil.formatText(nachrichtTo.getText()));
        super.create(nachricht);

        Pageable pageable = PageRequest.of(0, nachrichtTo.getSizing());
        Page<Nachricht> page = super.getPageByThemaId(nachrichtTo.getThemaId(), pageable);

        return nachrichtTo.isNew()? page.getTotalPages() - 1 : null;
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

    private Nachricht createNachrichtWithUpdaters(Integer id, String action) {
        Nachricht nachricht = get(id);
        List<NachrichtUpdater> updaters = nachricht.getUpdaters();
        updaters.add(nachrichtUpdaterService.save(new NachrichtTo(id).createUpdater(action)));
        nachricht.setUpdaters(updaters);
        return nachricht;
    }
}

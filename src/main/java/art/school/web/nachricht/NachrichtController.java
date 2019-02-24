package art.school.web.nachricht;

import art.school.entity.Nachricht;
import art.school.entity.NachrichtUpdater;
import art.school.entity.NachrichtUpdaterId;
import art.school.entity.Thema;
import art.school.service.NachrichtUpdaterService;
import art.school.service.ThemaService;
import art.school.service.UserService;
import art.school.to.NachrichtTo;
import art.school.util.TextFormatUtil;
import art.school.web.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

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
    public String getAllNachrichts(Model model, @RequestParam(name = "id") Integer id) {
        Thema thema = themaService.get(id);
        model.addAttribute("title", thema.getTitel());
        model.addAttribute("themaId", id);
        model.addAttribute("list", thema.getNachrichts()
                .stream()
                .sorted(Comparator.comparing(Nachricht::getDatum).thenComparing(Nachricht::getId))
                .map(NachrichtTo::new)
                .collect(Collectors.toCollection(LinkedHashSet::new)));
        model.addAttribute("current", SecurityUtil.getAuthId());
        return "nachricht";
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    public void createOrUpdate(NachrichtTo nachrichtTo) {
        System.out.println(nachrichtTo.isNew());
        Nachricht nachricht;
        if(nachrichtTo.isNew()){
            nachricht = new Nachricht();
            nachricht.setDatum(LocalDateTime.now());
        } else {
            nachricht = createNachrichtWithUpdaters(nachrichtTo.getId(), "Изменил");
        }
        nachricht.setThema(themaService.get(nachrichtTo.getThemaId()));
        nachricht.setUser(userService.get(SecurityUtil.getAuthId()));
        nachricht.setText(TextFormatUtil.formatText(nachrichtTo.getText()));
        super.create(nachricht);
    }

    @GetMapping(value="/delete")
    @ResponseBody
    public String delete(@RequestParam(name = "id") Integer id){
        Nachricht nachricht = createNachrichtWithUpdaters(id, "Удалил");
        String deleted = "<-- Удалено -->";
        nachricht.setText("<-- Deleted -->");
        super.create(nachricht);
        return deleted;
    }

    private Nachricht createNachrichtWithUpdaters(Integer id, String action){
        Nachricht nachricht = get(id);
        List<NachrichtUpdater> updaters = nachricht.getUpdaters();
        updaters.add(nachrichtUpdaterService.save(new NachrichtTo(id).createUpdater(action)));
        nachricht.setUpdaters(updaters);
        return nachricht;
    }
}

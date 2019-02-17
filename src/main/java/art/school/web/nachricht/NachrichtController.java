package art.school.web.nachricht;

import art.school.entity.Nachricht;
import art.school.entity.Thema;
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
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/nachricht")
public class NachrichtController extends AbstractNachrichtController {

    @Autowired
    private ThemaService themaService;

    @Autowired
    private UserService userService;

    @GetMapping
    public String getAllNachrichts(Model model, @RequestParam(name = "id") Integer id) {
        Thema thema = themaService.get(id);
        model.addAttribute("title", thema.getTitel());
        model.addAttribute("themaId", id);
        model.addAttribute("list", thema.getNachrichts()
                .stream()
                .map(NachrichtTo::new)
                .collect(Collectors.toCollection(LinkedHashSet::new)));
        model.addAttribute("current", SecurityUtil.getAuthId());
        return "nachricht";
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    public void createOrUpdate(NachrichtTo nachrichtTo) {
        Nachricht nachricht = nachrichtTo.isNew() ? new Nachricht() : get(nachrichtTo.getId());
        nachricht.setThema(themaService.get(nachrichtTo.getThemaId()));
        nachricht.setUser(userService.get(SecurityUtil.getAuthId()));
        nachricht.setText(TextFormatUtil.formatText(nachrichtTo.getText()));
        nachricht.setDatum(LocalDateTime.now());
        super.create(nachricht);
    }
}

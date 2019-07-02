package art.school.web.nachricht;

import art.school.entity.Nachricht;
import art.school.entity.NachrichtUpdater;
import art.school.entity.Thema;
import art.school.to.NachrichtTo;
import art.school.util.TextFormatUtil;
import art.school.web.SecurityUtil;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import static art.school.util.DateUtil.convertDateToToString;
import static art.school.util.DateUtil.transformDateInTo;
import static art.school.util.PaginationUtil.createTablePage;

@Controller
@RequestMapping(value = "/nachricht")
@Secured("ROLE_USER")
public class NachrichtController extends AbstractNachrichtController {

    @GetMapping
    public String getAllNachrichts(Model model, @RequestParam(name = "id") Integer id,
                                   @RequestParam(name = "select", required = false, defaultValue = "false") boolean select,
                                   @RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
                                   @RequestParam(name = "size", required = false, defaultValue = "10") int size,
                                   @RequestParam(name = "themaPage", defaultValue = "0") int themaPage,
                                   @RequestParam(name = "themaSize", defaultValue = "10") int themaSize) {
        Thema thema = themaService.get(id);

        model.addAttribute("title", thema.getTitel());
        model.addAttribute("themaId", id);
        model.addAttribute("themaPage", themaPage);
        model.addAttribute("themaSize", themaSize);
        model.addAttribute("isAttached", thema.isGepinnt());
        if (!thema.isAktiv()) {
            model.addAttribute("active", thema.isAktiv());
            model.addAttribute("closedBy", userService.getUsersByThemaId(id).getName());
        }

        Locale locale = LocaleContextHolder.getLocale();
        Map.Entry<List<NachrichtTo>, Page<Nachricht>> entry = super
                .getAllTosAsMap(id, PageRequest.of(pageNumber, size, Sort.by("datum", "id")))
                .entrySet().iterator().next();
        model.addAttribute("list", entry.getKey()
                .stream()
                .peek(i -> {
                    i.setDatum(convertDateToToString(i.getDatumTo(), messageSource, locale));
                    NachrichtUpdater u = i.getUpdater();
                    if (u != null) {
                        i.setUpdaterInfo(message.get(u.getAction()) + " " +
                                u.getUser().getName() + " "
                                + convertDateToToString(transformDateInTo(u.getDatum()), messageSource, locale).toLowerCase());
                    }
                }).collect(Collectors.toList()));
        model.addAttribute("link", "nachricht");
        model.addAttribute("isBanned", userService.isUserBanned(SecurityUtil.getAuthId()));
        createTablePage(model, entry.getValue());

        return select ? "nachricht/fragment" : "nachricht/nachricht";
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    public NachrichtTo createOrUpdate(NachrichtTo nachrichtTo,
                                      @RequestParam(name = "page") int pageNumber,
                                      @RequestParam(name = "parentId", required = false) Integer parentId) {

        Nachricht nachricht;
        if (nachrichtTo.isNew()) {
            nachricht = new Nachricht();
            nachricht.setDatum(LocalDateTime.now());
            nachricht.setUser(userService.get(SecurityUtil.getAuthId()));
            if (parentId != null) {
                nachricht.setParent(super.get(parentId));
            }
        } else {
            nachricht = createNachrichtWithUpdaters(nachrichtTo.getId(), "forum.changedBy");
        }
        nachricht.setThema(themaService.get(nachrichtTo.getThemaId()));
        nachricht.setText(nachrichtTo.getText());
        super.create(nachricht);

        Pageable pageable = PageRequest.of(pageNumber, nachrichtTo.getSize());
        Page<Nachricht> page = super.getPageByThemaId(nachrichtTo.getThemaId(), pageable);

        return new NachrichtTo(nachricht.getId(), nachrichtTo.isNew() ? page.getTotalPages() - 1 : pageNumber - 1, nachrichtTo.isNew());
    }

    @GetMapping(value = "/delete")
    @ResponseBody
    public String delete(@RequestParam(name = "id") Integer id) {
        Nachricht nachricht = createNachrichtWithUpdaters(id, "forum.deletedBy");
        String deleted = "<-- Удалено -->";
        nachricht.setText("<-- Deleted -->");
        super.create(nachricht);
        return deleted;
    }

    @GetMapping(value = "/text")
    public String getTextArea(Model model, @RequestParam(name = "id", required = false) Integer id,
                              @RequestParam(name = "answer", required = false, defaultValue = "false") boolean answer) {
        if (id != null) {
            Nachricht nachricht = get(id);
            model.addAttribute("parentText", answer ? nachricht.getText() :
                    nachricht.getParent() != null ? nachricht.getParent().getText() : null);
            model.addAttribute("id", answer ? null : id);
            model.addAttribute("themaId", nachricht.getThema().getId());
            model.addAttribute("updateText", answer ? null : TextFormatUtil.splitMessageByLineSeparator(nachricht.getText()));
        }
        return "forms/nachricht-form";
    }
}

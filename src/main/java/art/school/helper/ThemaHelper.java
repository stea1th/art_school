package art.school.helper;

import art.school.entity.Nachricht;
import art.school.entity.Thema;
import art.school.to.ThemaTo;
import art.school.util.DateUtil;
import org.springframework.stereotype.Component;

import java.util.ArrayDeque;
import java.util.Deque;

@Component
public class ThemaHelper {

    public ThemaTo createTo(Thema t){
        ThemaTo to = new ThemaTo();
        Deque<Nachricht> nachrichts = new ArrayDeque<>(t.getNachrichts());

        to.setId(t.getId());
        to.setTitel(t.getTitel());
        to.setCreator(nachrichts.getFirst().getUser().getName());
        to.setViews(t.getViews());
        to.setReplies(nachrichts.size() - 1);
        to.setDateTo(DateUtil.transformDateInTo(nachrichts.getLast().getDatum()));
        to.setPinned(t.isGepinnt());
        to.setPage(nachrichts.size()/10);
        to.setAnker(nachrichts.getLast().getId());
        to.setLastName(nachrichts.getLast().getUser().getName());
        to.setAktiv(t.isAktiv());

        return to;
    }

    public Thema createThema(String title){
        return createThema(null, title, 0, true, false);
    }

    public Thema createThema(Integer id, String titel, int views, boolean aktiv, boolean gepinnt) {
        Thema t = new Thema();
        t.setId(id);
        t.setTitel(titel);
        t.setViews(views);
        t.setAktiv(aktiv);
        t.setGepinnt(gepinnt);

        return t;
    }
}

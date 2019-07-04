package art.school.helper;

import art.school.entity.*;
import art.school.to.NachrichtTo;
import art.school.util.DateUtil;
import art.school.util.FileUtil;
import art.school.web.SecurityUtil;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

import static art.school.util.DateUtil.transformDateInTo;
import static art.school.util.TextFormatUtil.escapeText;
import static art.school.util.TextFormatUtil.splitMessageByLineSeparator;

@Component
public class NachrichtHelper {

    public NachrichtTo createTo(Nachricht n) {

        NachrichtTo to = new NachrichtTo();
        Users user = n.getUser();
        Thema thema = n.getThema();
        Deque<NachrichtUpdater> updaters = new ArrayDeque<>(n.getUpdaters());
        Nachricht parent = n.getParent();

        to.setId(n.getId());
        to.setText(escapeText(n.getText()));
        to.setDatumTo(transformDateInTo(n.getDatum()));
        to.setName(user.getName());
        to.setUserId(user.getId());
        to.setThemaId(thema.getId());
        to.setUpdater(updaters.isEmpty() ? null :
                updaters.pop());
        to.setLines(splitMessageByLineSeparator(escapeText(n.getText())));
        to.setParentMessages(parent == null ? null : splitMessageByLineSeparator(escapeText(parent.getText())));
        to.setRoleSize(user.getRoles().size());
        to.setRegistriert(DateUtil.formatDateToString(user.getRegistriert()));
        to.setMessages(user.getNachrichts().size());
        to.setEncodedImage(FileUtil.convertByteArrayToString(user.getImage()));
        to.setActive(user.getAktiv());

        return to;
    }

    public NachrichtTo createTo(int id, int page, boolean reload) {
        NachrichtTo to = createTo(id);
        to.setPage(page);
        to.setReload(reload);
        return to;
    }

    public NachrichtTo createTo(int id) {
        NachrichtTo to = new NachrichtTo();
        to.setId(id);
        return to;
    }

    public NachrichtUpdater createUpdater(int id, String action) {
        NachrichtUpdater updater = new NachrichtUpdater();
        updater.setId(new NachrichtUpdaterId(SecurityUtil.getAuthId(), id));
        updater.setDatum(LocalDateTime.now());
        updater.setAction(action);
        return updater;
    }

    public Nachricht createNachricht(Integer id, String text, LocalDateTime datum) {
        Nachricht n = new Nachricht();
        n.setId(id);
        n.setText(text);
        n.setDatum(datum);
        return n;
    }

    public Nachricht createNachricht(String text) {
        return createNachricht(null, text, LocalDateTime.now());
    }

    public List<NachrichtTo> transformTos(List<Nachricht> list) {
        return list.stream().map(this::createTo)
                .collect(Collectors.toList());
    }
}

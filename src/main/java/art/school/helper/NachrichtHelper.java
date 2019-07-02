package art.school.helper;

import art.school.entity.Nachricht;
import art.school.entity.NachrichtUpdater;
import art.school.entity.Thema;
import art.school.entity.Users;
import art.school.to.NachrichtTo;
import art.school.util.FileUtil;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.List;

import static art.school.util.DateUtil.transformDateInTo;
import static art.school.util.TextFormatUtil.splitMessageByLineSeparator;

@Component
public class NachrichtHelper {

    public NachrichtTo createNachrichtTo(Nachricht n) {

        NachrichtTo to = new NachrichtTo();
        Users user = n.getUser();
        Thema thema = n.getThema();
        List<NachrichtUpdater> updaters = n.getUpdaters();
        Nachricht parent = n.getParent();

        to.setId(n.getId());
        to.setText(n.getText());
        to.setDatumTo(transformDateInTo(n.getDatum()));
        to.setName(user.getName());
        to.setUserId(n.getUser().getId());
        to.setThemaId(thema.getId());
        to.setUpdater(updaters.isEmpty() ? null :
                updaters.get(updaters.size() - 1));
        to.setLines(splitMessageByLineSeparator(n.getText()));
        to.setParentMessages(parent == null ? null : splitMessageByLineSeparator(parent.getText()));
        to.setRoleSize(user.getRoles().size());
        to.setRegistriert(user.getRegistriert().toLocalDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        to.setMessages(user.getNachrichts().size());
        to.setEncodedImage(FileUtil.convertByteArrayToString(user.getImage()));
        to.setActive(user.getAktiv());

        return to;
    }


}

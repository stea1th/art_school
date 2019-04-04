package art.school.to;


import art.school.entity.Nachricht;
import art.school.entity.NachrichtUpdater;
import art.school.entity.NachrichtUpdaterId;
import art.school.util.DateUtil;
import art.school.web.SecurityUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static art.school.util.TextFormatUtil.splitMessageByLineSeparator;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NachrichtTo {

    private Integer id;
    private String text;
    private DateTo datumTo;
    private String datum;
    private String name;
    private Integer userId;
    private Integer themaId;
    private NachrichtUpdater updater;
    private String updaterInfo;
    private Integer size;
    private List<String> lines;
    private List<String> parentMessages;
    private Integer page;
    private Boolean reload;
    private Integer roleSize;
    private String registriert;
    private Integer messages;
    private String banned;

    public NachrichtTo(Nachricht n) {
        this(n.getId(), n.getText(),
                DateUtil.transformDateInTo(n.getDatum()),
                n.getUser().getName(), n.getUser().getId(),
                n.getThema().getId(), n.getUpdaters().isEmpty() ? null :
                        n.getUpdaters().get(n.getUpdaters().size() - 1),
                splitMessageByLineSeparator(n.getText()),
                n.getParent() == null ? null : splitMessageByLineSeparator(n.getParent().getText()),
                n.getUser().getRoles().size(),
                n.getUser().getRegistriert().toLocalDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                n.getUser().getNachrichts().size());
    }

    public NachrichtTo(Integer id) {
        this.id = id;
    }

    public NachrichtTo(int id, int page, boolean reload) {
        this.id = id;
        this.page = page;
        this.reload = reload;
    }

    NachrichtTo(Integer id, String text,
                DateTo datumTo, String name,
                Integer userId, Integer themaId,
                NachrichtUpdater updater,
                List<String> lines, List<String> parentMessages,
                Integer roleSize,
                String registriert, Integer messages) {
        this.id = id;
        this.text = text;
        this.datumTo = datumTo;
        this.name = name;
        this.userId = userId;
        this.themaId = themaId;
        this.updater = updater;
        this.lines = lines;
        this.parentMessages = parentMessages;
        this.roleSize = roleSize;
        this.registriert = registriert;
        this.messages = messages;
    }

    public boolean isNew() {
        return (id == null || id.equals(themaId));
    }

    public NachrichtUpdater createUpdater(String action) {
        NachrichtUpdater updater = new NachrichtUpdater();
        updater.setId(new NachrichtUpdaterId(SecurityUtil.getAuthId(), id));
        updater.setDatum(LocalDateTime.now());
        updater.setAction(action);
        return updater;
    }
}

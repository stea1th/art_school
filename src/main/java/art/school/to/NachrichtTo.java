package art.school.to;


import art.school.entity.Nachricht;
import art.school.entity.NachrichtUpdater;
import art.school.entity.NachrichtUpdaterId;
import art.school.util.DateUtil;
import art.school.util.TextFormatUtil;
import art.school.web.SecurityUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NachrichtTo {

    private Integer id;
    private String text;
    private String datum;
    private String name;
    private Integer userId;
    private Integer themaId;
    private String updaterInfo;
    private Integer sizing;

    public NachrichtTo(Nachricht n){
        this(n.getId(), n.getText(),
                DateUtil.transformDateForForum(n.getDatum()),
                n.getUser().getName(), n.getUser().getId(),
                n.getThema().getId(), n.getUpdaters().isEmpty()? null :
        TextFormatUtil.createUpdaterInfo(n.getUpdaters().get(n.getUpdaters().size()-1)), null);
    }

    public NachrichtTo(Integer id) {
        this.id = id;
    }

    public boolean isNew() {
        return (id == null || id.equals(themaId));
    }

    public NachrichtUpdater createUpdater(String action){
        NachrichtUpdater updater = new NachrichtUpdater();
        updater.setId(new NachrichtUpdaterId(SecurityUtil.getAuthId(), id));
        updater.setDatum(LocalDateTime.now());
        updater.setAction(action);
        return updater;
    }

//    public Nachricht createNachricht(){
//
//    }

}

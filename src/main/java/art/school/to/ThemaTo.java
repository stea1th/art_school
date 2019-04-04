package art.school.to;


import art.school.entity.Thema;
import art.school.util.DateUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ThemaTo {

    private Integer id;
    private String titel;
    private String creator;
    private int views;
    private int replies;
    private DateTo dateTo;
    private String last;
    private boolean pinned;
    private int page;
    private int anker;
    private String lastName;
    private boolean aktiv;

    public ThemaTo(Thema thema){
        this(thema.getId(), thema.getTitel(), thema.getNachrichts()
                        .get(0)
                        .getUser()
                        .getName(),
                thema.getViews(),
                thema.getNachrichts().size()-1,
                DateUtil.transformDateInTo(thema.getNachrichts().get(thema.getNachrichts().size()-1)
                        .getDatum()),
                thema.isGepinnt(),
                thema.getNachrichts().size()/10,
                thema.getNachrichts().get(thema.getNachrichts().size()-1).getId(),
                thema.getNachrichts().get(thema.getNachrichts().size()-1).getUser().getName(),
                thema.isAktiv());
    }

    public ThemaTo(Integer id, String titel, String creator, int views, int replies, DateTo dateTo, boolean pinned, int page, int anker, String lastName, boolean aktiv) {
        this.id = id;
        this.titel = titel;
        this.creator = creator;
        this.views = views;
        this.replies = replies;
        this.dateTo = dateTo;
        this.pinned = pinned;
        this.page = page;
        this.anker = anker;
        this.lastName = lastName;
        this.aktiv = aktiv;
    }
}

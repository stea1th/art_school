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
                DateUtil.transformDateForForum(thema.getNachrichts().get(thema.getNachrichts().size()-1)
                        .getDatum()),
                thema.isGepinnt(),
                thema.getNachrichts().size()/10,
                thema.getNachrichts().get(thema.getNachrichts().size()-1).getId(),
                thema.getNachrichts().get(thema.getNachrichts().size()-1).getUser().getName(),
                thema.isAktiv());
    }
}

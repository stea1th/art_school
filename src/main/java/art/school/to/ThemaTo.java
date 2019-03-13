package art.school.to;


import art.school.entity.Nachricht;
import art.school.entity.Thema;
import art.school.util.DateUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Comparator;
import java.util.stream.Collectors;

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

    public ThemaTo(Thema thema){
        this(thema.getId(), thema.getTitel(), thema.getNachrichts()
                        .stream()
                        .sorted(Comparator.comparing(Nachricht::getId))
                        .collect(Collectors.toList())
                        .get(0)
                        .getUser()
                        .getName(),
                thema.getViews(),
                thema.getNachrichts().size()-1,
                DateUtil.transformDateForForum(thema.getNachrichts().get(0)
                        .getDatum()),
                thema.isGepinnt()
                );
    }
}

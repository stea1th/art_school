package art.school.to;


import art.school.entity.Nachricht;
import art.school.util.DateUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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

    public NachrichtTo(Nachricht n){
        this(n.getId(), n.getText(),
                DateUtil.transformDateForForum(n.getDatum()),
                n.getUser().getName(), n.getUser().getId(), n.getThema().getId());
    }

}

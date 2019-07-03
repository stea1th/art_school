package art.school.to;


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

}

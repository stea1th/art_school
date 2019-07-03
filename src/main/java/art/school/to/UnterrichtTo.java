package art.school.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnterrichtTo {

    private Integer id;
    private String title;
    private String start;
    private String end;
    private String notiz;
    private String color;

}

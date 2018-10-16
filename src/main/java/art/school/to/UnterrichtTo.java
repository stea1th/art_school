package art.school.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnterrichtTo implements Serializable {


    private String title;
    private String start;
    private String end;
//    private String description;
//    private String url;


}

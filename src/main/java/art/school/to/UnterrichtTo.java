package art.school.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnterrichtTo implements Serializable {

    private String date;
    private String title;
    private String description;


}

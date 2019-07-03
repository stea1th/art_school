package art.school.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlockTo {

    private Integer interval;
    private String timeUnit;
    private String reason;
    private String date;
    private String blockedByName;

}

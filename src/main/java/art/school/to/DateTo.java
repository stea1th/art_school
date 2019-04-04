package art.school.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DateTo {

    private String code;
    private String time;
    private Integer days;

    public DateTo(String code, String time) {
        this(code, time, null);
    }

    public DateTo(String time) {
        this.time = time;
    }
}

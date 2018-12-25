package art.school.statik;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Month;
import java.util.List;

@Data
@AllArgsConstructor
public class MonthForStatistik {

    private String name;
    private Month monat;
    private BigDecimal value;
    private List<WeeksForStatistik> childrens;
}

package art.school.statik;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Month;

@Data
@AllArgsConstructor
public class MonthForStatistik {

    private Month monat;
    private Double sum;
}

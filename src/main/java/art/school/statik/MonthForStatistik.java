package art.school.statik;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Month;
import java.util.List;

@Data
@AllArgsConstructor
public class MonthForStatistik {

    private String name;
    private Month monat;
    private Double value;
    private List<WeeksForStatistik> childrens;

    public MonthForStatistik(Month monat, Double value, List<WeeksForStatistik> childrens) {
        this.monat = monat;
        this.value = value;
        this.childrens = childrens;
    }
}

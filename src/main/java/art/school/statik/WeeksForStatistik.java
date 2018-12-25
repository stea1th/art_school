package art.school.statik;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class WeeksForStatistik {

    private Integer nummer;
    private String name;
    private BigDecimal value;
    private List<DaysForStatistik> childrens;

    public WeeksForStatistik(Integer nummer, String name, BigDecimal value) {
        this.nummer = nummer;
        this.name = name;
        this.value = value;
    }
}

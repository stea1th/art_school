package art.school.statik;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class WeeksForStatistik {

    private Integer nummer;
    private String name;
    private Double value;
    private List<DaysForStatistik> days;

    public WeeksForStatistik(Integer nummer, String name, Double value) {
        this.nummer = nummer;
        this.name = name;
        this.value = value;
    }
}

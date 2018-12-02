package art.school.web.unterricht;

import art.school.statik.MonthForStatistik;
import art.school.util.DataForStatistik;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/statistik")
public class StatistikRestController extends AbstractUnterrichtController {

    @GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<Integer, MonthForStatistik> testStatistik() {
//        map.forEach((k, v) -> System.out.println("Sum for " + k + " are " + BigDecimal.valueOf(v).setScale(2, RoundingMode.CEILING)));
        return DataForStatistik.getResponse(super.getAll());
    }
}

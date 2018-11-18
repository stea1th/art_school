package art.school.web.unterricht;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/statistik")
public class StatistikRestController extends AbstractUnterrichtController {

    @GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<Integer, Double> testStatistik() {

        Map<Integer, Double> map = super.getAll().stream()
                .collect(Collectors.groupingBy(i -> i.getDatum()
                                .toLocalDate()
                                .getMonth().getValue(),
                        Collectors.summingDouble(x -> x.getZahlung().getPreis().doubleValue())));

        map.forEach((k, v) -> System.out.println("Sum for " + k + " are " + BigDecimal.valueOf(v).setScale(2, RoundingMode.CEILING)));

        return map;
    }
}

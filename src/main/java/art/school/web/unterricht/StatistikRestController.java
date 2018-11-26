package art.school.web.unterricht;

import art.school.statik.MonthForStatistik;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Month;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/statistik")
public class StatistikRestController extends AbstractUnterrichtController {

    @GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public MultiValueMap<Integer, MonthForStatistik> testStatistik() {


        Map<Month, Double> map = super.getAll().stream()
                .collect(Collectors.groupingBy(i -> i.getDatum()
                                .toLocalDate()
                                .getMonth(),
                        Collectors.summingDouble(x -> x.getZahlung().getPreis().doubleValue())));
//
        List<MonthForStatistik> collect = map.entrySet()
                .stream()
                .map((e) -> new MonthForStatistik(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
//        collect.sort();
        MultiValueMap<Integer, MonthForStatistik> response = new LinkedMultiValueMap<>();
        collect.forEach(i-> response.add(i.getMonat().getValue(), i));

//        map.forEach((k, v) -> System.out.println("Sum for " + k + " are " + BigDecimal.valueOf(v).setScale(2, RoundingMode.CEILING)));
        return response;
    }
}

package art.school.web.unterricht;

import art.school.statik.MonthForStatistik;
import art.school.util.DataForStatistik;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;


@RestController
@RequestMapping(value = "/api/statistik")
public class StatistikRestController extends AbstractUnterrichtController {

    @GetMapping(value = "/chart/{year}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MonthForStatistik> getStatistik(@PathVariable("year") int year) {
//        map.forEach((k, v) -> System.out.println("Sum for " + k + " are " + BigDecimal.valueOf(v).setScale(2, RoundingMode.CEILING)));
//        DataForStatistik.test();
//        DataForStatistik.getAllWeeksForMonth(Month.DECEMBER);
        return DataForStatistik.getResponse(super.getAllByYear(year));
    }

    @GetMapping(value ="/years", produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<Integer> getAllYears() {
        return super.getYears();
    }
}

package art.school.web.unterricht;

import art.school.statik.MonthForStatistik;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/api/statistik")
@Secured("ROLE_MODERATOR")
public class StatistikRestController extends AbstractUnterrichtController {

    @GetMapping(value = "/chart/{year}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MonthForStatistik> getStatistik(@PathVariable("year") int year) {
        return super.getStatistik(year);
    }

    @GetMapping(value = "/years", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getAllYears() {
        return super.getYears();
    }
}

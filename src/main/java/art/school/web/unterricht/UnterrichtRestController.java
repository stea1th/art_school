package art.school.web.unterricht;


import art.school.entity.Unterricht;
import art.school.to.UnterrichtTo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/unterricht")
public class UnterrichtRestController extends AbstractUnterrichtController {


//    public List<Unterricht> getAll() {
//        return super.getAll();
//    }

    @PostMapping("unterricht/save")
//    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public String create(HttpServletRequest request){
        super.create(new Unterricht(LocalDateTime.of(LocalDate.parse(request.getParameter("datum")),
                LocalTime.parse(request.getParameter("timepicker"))), true, "This is just a test"),
                Integer.parseInt(request.getParameter("kind")), Integer.parseInt(request.getParameter("zahlung")));
        return "unterricht";
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAllThis() throws JsonProcessingException {
        List<UnterrichtTo> list = new ArrayList<>();
        super.getAll().forEach(i-> list.add(new UnterrichtTo(i.getKind().getName(),
                i.getDatum().toString(),
                i.getDatum().plus(i.getZahlung().getDauer().getLong(ChronoField.MINUTE_OF_DAY), ChronoUnit.MINUTES).toString())));
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        return ow.writeValueAsString(list);
    }
}

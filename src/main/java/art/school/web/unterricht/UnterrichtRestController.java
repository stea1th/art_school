package art.school.web.unterricht;


import art.school.entity.Unterricht;
import art.school.to.UnterrichtTo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping(value = "/unterricht")
public class UnterrichtRestController extends AbstractUnterrichtController {


//    public List<Unterricht> getAll() {
//        return super.getAll();
//    }

//    @PostMapping(value="/saveUnterricht")
//    @ResponseStatus(value = HttpStatus.NO_CONTENT)
//    public ResponseEntity<String> create(@RequestBody String json) throws IOException {
////        super.create(new Unterricht(LocalDateTime.of(LocalDate.parse(request.getParameter("datum")),
////                LocalTime.parse(request.getParameter("timepicker"))), true, "This is just a test"),
////                Integer.parseInt(request.getParameter("kind")), Integer.parseInt(request.getParameter("zahlung")));
////        ObjectMapper mapper = new ObjectMapper();
////        String[] strings = mapper.readValue(json, String[].class);
////        Stream.of(strings).forEach(System.out::println);
//        System.out.println(json);
//
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

    @PostMapping(value="/save")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public ResponseEntity<String> create(
            @RequestParam(value = "id", required = false) String id,
            @RequestParam(value = "datum") String datum,
            @RequestParam(value = "timepicker", required = false) String zeit,
            @RequestParam(value = "kind") String kind,
            @RequestParam(value = "zahlung") String zahlung,
            @RequestParam(value = "bezahlt", defaultValue = "false") String bezahlt,
            @RequestParam(value = "notiz", required = false) String notiz
    )  {
        Unterricht u = new Unterricht(LocalDateTime.of(LocalDate.parse(datum), LocalTime.parse(zeit)), Boolean.valueOf(bezahlt), notiz);
        super.create(u, Integer.parseInt(kind), Integer.parseInt(zahlung));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UnterrichtTo> all(){
        List<UnterrichtTo> list = new ArrayList<>();
        super.getAll().forEach(i-> list.add(new UnterrichtTo(i.getId(), i.getKind().getName(),
                i.getDatum().minusMonths(1).truncatedTo(ChronoUnit.SECONDS),
                i.getDatum().minusMonths(1).truncatedTo(ChronoUnit.SECONDS).plusMinutes(i.getZahlung().getDauer().getLong(ChronoField.MINUTE_OF_DAY)), i.getNotiz(),
                !i.getKind().isAktiv()? "grey" : i.isBezahlt()? "green" : "red")));

        return list;
    }
}

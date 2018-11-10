package art.school.web.unterricht;


import art.school.entity.Unterricht;
import art.school.to.RequestUnterrichtTo;
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

    @PostMapping(value="/save", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public ResponseEntity<String> create(RequestUnterrichtTo unterrichtTo)  {
//        Unterricht u = new Unterricht(LocalDateTime.of(LocalDate.parse(datum), LocalTime.parse(zeit)), Boolean.valueOf(bezahlt), notiz);
//        super.create(u, Integer.parseInt(kind), Integer.parseInt(zahlung));
        System.out.println(unterrichtTo.getDatum()+" "+unterrichtTo.getKind()+" "+unterrichtTo.getId()+" ");
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

    @PostMapping(value="/update/ondrop/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public ResponseEntity<String> updateOnDrop(
            @PathVariable("id") int id,
            @RequestParam(value = "date") String date){
        String[] dateParts = date.replace("T", " ").split(" ");
        Unterricht u = super.get(id);
        u.setDatum(LocalDateTime.of(LocalDate.parse(dateParts[0]), LocalTime.parse(dateParts[1])));
        super.update(u, id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}

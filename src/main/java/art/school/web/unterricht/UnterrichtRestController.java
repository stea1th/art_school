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
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping(value = "/unterricht")
public class UnterrichtRestController extends AbstractUnterrichtController {

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public ResponseEntity<String> create(RequestUnterrichtTo unterrichtTo) {
        Unterricht u = new Unterricht(LocalDateTime.of(LocalDate.parse(unterrichtTo.getDatum()),
                LocalTime.parse(unterrichtTo.getZeit())), unterrichtTo.isBezahlt(), unterrichtTo.getNotiz());
        System.out.println(u);
        super.create(u, unterrichtTo.getKind(), unterrichtTo.getZahlung());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UnterrichtTo> all() {
        List<UnterrichtTo> list = new ArrayList<>();
        super.getAll().forEach(i -> list.add(new UnterrichtTo(i.getId(), i.getKind().getName(),
                i.getDatum().truncatedTo(ChronoUnit.SECONDS).toString(),
                i.getDatum().truncatedTo(ChronoUnit.SECONDS).plusMinutes(i.getZahlung().getDauer().getLong(ChronoField.MINUTE_OF_DAY)).toString(), i.getNotiz(),
                !i.getKind().isAktiv() ? "grey" : i.isBezahlt() ? "green" : "red")));

//        super.getAll().forEach(System.out::println);
//
//        System.out.println("<======================================>");
//
//        list.forEach(System.out::println);

        return list;
    }

    @PostMapping(value = "/update/ondrop/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public ResponseEntity<String> updateOnDrop(
            @PathVariable("id") int id,
            @RequestParam(value = "date") String date) {
        System.out.println(date);
        String[] dateParts = date.replace("T", " ").split(" ");
        Unterricht u = super.get(id);
        u.setDatum(LocalDateTime.of(LocalDate.parse(dateParts[0]), LocalTime.parse(dateParts[1])));
        super.update(u, id);

        return new ResponseEntity<>(HttpStatus.OK);
    }



}

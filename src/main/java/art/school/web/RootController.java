package art.school.web;

import art.school.to.UnterrichtTo;
import art.school.web.unterricht.AbstractUnterrichtController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RootController extends AbstractUnterrichtController {

//    @GetMapping("/")
//    public String root(Model model) throws JsonProcessingException {
//        List<UnterrichtTo> list = new ArrayList<>();
//        super.getAll().forEach(i-> list.add(new UnterrichtTo(i.getDatum()
//                .truncatedTo(ChronoUnit.SECONDS)
//                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
//                i.getKind().getName(),
//                i.getNotiz(),
//                "?id="+i.getId())));
//        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//        String json = ow.writeValueAsString(list);
//        model.addAttribute("json", json);
//
//        return "eventcalendar";
//    }

    @GetMapping("/")
    public String root(){
        return "index";
    }

}

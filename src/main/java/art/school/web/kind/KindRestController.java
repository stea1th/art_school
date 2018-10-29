package art.school.web.kind;

import art.school.entity.Kind;
import art.school.to.KindTo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/kind")
public class KindRestController extends AbstractKindController{


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<KindTo> all(){
        List<KindTo> list = new ArrayList<>();
        super.getAll().forEach(i-> list.add(new KindTo(i.getId(),
                i.getName(), i.getAdresse(), i.isAktiv(), i.getRegistriert().truncatedTo(ChronoUnit.SECONDS).toString().replace("T", " "))));
        return list;
    }

}

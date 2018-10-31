package art.school.web.kind;

import art.school.to.KindTo;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
                i.getName(), i.getAdresse(), i.isAktiv(),
                i.getRegistriert().truncatedTo(ChronoUnit.SECONDS).toString().replace("T", " "))));
        return list;
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id){
        System.out.println(id);
        super.delete(id);
    }
}

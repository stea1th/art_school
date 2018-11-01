package art.school.web.zahlung;

import art.school.to.ZahlungTo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/zahlung")
public class ZahlungRestController extends AbstractZahlungController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ZahlungTo> all() {
        return super.getAll().stream().map(ZahlungTo::new).collect(Collectors.toList());
    }

}

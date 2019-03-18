package art.school.web.user;

import art.school.to.UserTo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static art.school.util.TransformUtil.transformTo;

@RestController
@RequestMapping(value = "/kind")
public class KindRestController extends AbstractUserController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserTo> all() {
        return transformTo(super.getAllKinds(), UserTo.class);
        }

    @GetMapping(value="/filter/aktiv", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserTo> onlyAktiv(){
        return transformTo(super.getAllKinds(), UserTo.class)
                .stream()
                .filter(UserTo::getAktiv)
                .collect(Collectors.toList());
    }

}

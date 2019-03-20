package art.school.web.user;

import art.school.to.UserTo;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/kind")
@Secured("ROLE_MODERATOR")
public class KindRestController extends AbstractUserController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserTo> all() {
        return getAllKinds();
        }

    @GetMapping(value="/filter/aktiv", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserTo> onlyAktiv(){
        return getAllKinds()
                .stream()
                .filter(UserTo::getAktiv)
                .collect(Collectors.toList());
    }

}

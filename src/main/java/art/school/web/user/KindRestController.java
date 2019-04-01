package art.school.web.user;

import art.school.to.BlockTo;
import art.school.to.UserTo;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/kind")
@Secured("ROLE_USER")
public class KindRestController extends AbstractUserController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Secured("ROLE_MODERATOR")
    public List<UserTo> all() {
        return getAllKinds();
        }

    @GetMapping(value="/filter/aktiv", produces = MediaType.APPLICATION_JSON_VALUE)
    @Secured("ROLE_MODERATOR")
    public List<UserTo> onlyAktiv(){
        return getAllKinds()
                .stream()
                .filter(UserTo::getAktiv)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/check", produces = MediaType.APPLICATION_JSON_VALUE)
    public BlockTo checkIfBlocked() {
        return super.checkIfBlocked();
    }

    @PostMapping(value = "/accepted")
    public void accepted(){
        super.accepted();
    }

}

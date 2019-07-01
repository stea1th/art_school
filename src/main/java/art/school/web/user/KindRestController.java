package art.school.web.user;

import art.school.to.BlockTo;
import art.school.to.UserTo;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/kind")
@Secured("ROLE_USER")
public class KindRestController extends AbstractUserController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Secured("ROLE_MODERATOR")
    public List<UserTo> all() {
        return getAllKids();
    }

    @GetMapping(value = "/filter/aktiv", produces = MediaType.APPLICATION_JSON_VALUE)
    @Secured("ROLE_MODERATOR")
    public List<UserTo> onlyActive() {
        return super.getOnlyActiveKids();
    }

    @GetMapping(value = "/check", produces = MediaType.APPLICATION_JSON_VALUE)
    public BlockTo checkIfBlocked() {
        return super.checkIfBlocked();
    }

    @PostMapping(value = "/accepted")
    public void accepted() {
        super.accepted();
    }

}

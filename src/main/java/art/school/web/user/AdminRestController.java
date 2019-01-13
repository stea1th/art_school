package art.school.web.user;

import art.school.entity.Role;
import art.school.to.UserTo;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static art.school.util.TransformUtil.transformTo;

@RestController
@RequestMapping("/admin")
public class AdminRestController extends AbstractUserController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Secured("ROLE_ADMIN")
    public List<UserTo> all() {
        return transformTo(super.getAll(), UserTo.class);
    }

    @PostMapping("/toggle/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public ResponseEntity<String> toggle(@PathVariable("id") Integer id) {
        super.toggleAktiv(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/roles")
    public Map<Integer, String> getRoles(){
        return Arrays.stream(Role.values())
                .collect(Collectors.toMap(Enum::ordinal, Role::getName));
    }
}

package art.school.web.user;

import art.school.entity.Role;
import art.school.entity.Users;
import art.school.to.BlockTo;
import art.school.to.UserTo;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/admin")
@Secured("ROLE_MODERATOR")
public class AdminRestController extends AbstractUserController {


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Secured("ROLE_ADMIN")
    public List<UserTo> all() {
        return getAllTos().stream()
                .peek(i -> i.setRoles(message.get(i.getRoles())))
                .collect(Collectors.toList());
    }

    @PostMapping("/toggle/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public ResponseEntity<String> toggle(@PathVariable("id") Integer id) {
        super.toggleAktiv(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/roles")
    @Secured("ROLE_ADMIN")
    public Map<Integer, String> getRoles() {
        return Arrays.stream(Role.values())
                .collect(Collectors.toMap(Enum::ordinal, i -> message.get(i.getName())));
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public ResponseEntity saveOrUpdate(UserTo z) {

        Users kind = z.isNew() ? z.createUser() : z.updateUser(super.get(z.getId()));
        super.create(kind);
        return new ResponseEntity<>(Collections.singletonMap(z.isNew() ? "Save" : "Update", z.getName()), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserTo getUser(@PathVariable("id") int id) {
        UserTo user = getUserTo(id);
        user.setRoles(message.get(user.getRoles()));
        return user;
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id) {
        super.delete(id);
    }

    @PostMapping(value = "/block/{id}")
    public void block(@PathVariable(name = "id") int id,
                      BlockTo block) {
        super.blockUser(block, id);
    }

    @PostMapping(value = "/unblock")
    public void unblock(@RequestParam(name = "id") int id) {
        super.unblockUser(id);
    }
}

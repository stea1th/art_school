package art.school.web.user;

import art.school.entity.Role;
import art.school.entity.Users;
import art.school.to.BlockTo;
import art.school.to.UserTo;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/admin")
@Secured("ROLE_MODERATOR")
public class AdminRestController extends AbstractUserController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Secured("ROLE_ADMIN")
    public List<UserTo> all() {
        Locale locale = LocaleContextHolder.getLocale();
        return getAllTos().stream()
                .peek(i -> i.setRoles(messageSource.getMessage(i.getRoles(), null, locale)))
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
        Locale locale = LocaleContextHolder.getLocale();
        return Arrays.stream(Role.values())
                .collect(Collectors.toMap(Enum::ordinal, i -> messageSource.getMessage(i.getName(), null, locale)));
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @SuppressWarnings("unchecked")
    public ResponseEntity saveOrUpdate(UserTo z) {

        Map<String, String> response = new HashMap<>();
        Users kind = z.isNew() ? z.createUser() : z.updateUser(super.get(z.getId()));
        super.create(kind);
        response.put(z.isNew() ? "Save" : "Update", z.getName());
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserTo getUser(@PathVariable("id") int id) {
        Locale locale = LocaleContextHolder.getLocale();
        UserTo user = getUserTo(id);
        user.setRoles(messageSource.getMessage(user.getRoles(), null, locale));
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

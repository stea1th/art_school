package art.school.to;

import art.school.entity.Role;
import art.school.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.time.temporal.ChronoUnit;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserTo {

    private Integer id;
    private String name;
    private String email;
    private String passwort;
    private String roles;
    private boolean aktiv;
    private String registriert;

    public UserTo(User u) {
        this(u.getId(),
                u.getName(),
                u.getEmail(),
                u.getPasswort(),
                u.getRoles()
                        .stream()
                        .map(Role::getName)
                        .collect(Collectors.joining("," + System.lineSeparator())),
                u.getAktiv(),
                u.getRegistriert().truncatedTo(ChronoUnit.SECONDS)
                        .toString().replace("T", " "));

    }
}
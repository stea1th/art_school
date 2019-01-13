package art.school.to;

import art.school.entity.Role;
import art.school.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
    private String adminPasswort;
    private String roles;
//    private Role roles;
    private boolean aktiv;
    private String registriert;

    public UserTo(Users u) {
        this(u.getId(),
                u.getName(),
                u.getEmail(),
                u.getAdminPasswort(),
                u.getRoles()
                        .stream()
                        .sorted((x1, x2) -> x2.ordinal()-x1.ordinal())
                        .map(Role::getName)
                        .findFirst().orElse(null),
                u.getAktiv(),
                u.getRegistriert().truncatedTo(ChronoUnit.SECONDS)
                        .toString().replace("T", " "));

    }
}

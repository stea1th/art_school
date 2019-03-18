package art.school.to;

import art.school.entity.Role;
import art.school.entity.Users;
import art.school.util.RolesUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserTo {

    private Integer id;
    private String name;
    private String adresse;
    private String email;
    private String adminPasswort;
    private String roles;
    private Boolean aktiv;
    private String registriert;

    public UserTo(Users u) {
        this(u.getId(),
                u.getName(),
                u.getAdresse(),
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

    public Users createUser(){
        return new Users(
                id, name, email, adresse, adminPasswort == null? "1" : adminPasswort, LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS), aktiv,
                RolesUtil.createRoles(Integer.parseInt(roles == null? "0" : roles))
        );
    }

    public Users updateUser(Users u){
        u.setName(name);
        u.setEmail(email);
        u.setAdresse(adresse);
        u.setAdminPasswort(adminPasswort == null? "1" : adminPasswort);
        u.setAktiv(aktiv);
        u.setRoles(RolesUtil.createRoles(Integer.parseInt(roles == null? "0" : roles)));
        return u;
    }

    public boolean isNew(){
        return id == null;
    }
}

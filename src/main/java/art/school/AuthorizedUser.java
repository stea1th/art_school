package art.school;

import art.school.entity.Role;
import art.school.entity.Users;
import lombok.Getter;
import org.springframework.security.core.userdetails.User;

import java.util.Set;

@Getter
public class AuthorizedUser extends User {

    private Integer id;
    private String name;
    private Set<Role> roles;
    private Boolean aktiv;

    public AuthorizedUser(Users user) {
        super(user.getEmail(), user.getPasswords().get(0).getPasswort(), user.getAktiv(), true, true, true, user.getRoles());
        this.id = user.getId();
        this.name = user.getName();
        this.roles = user.getRoles();
        this.aktiv = user.getAktiv();
    }
}

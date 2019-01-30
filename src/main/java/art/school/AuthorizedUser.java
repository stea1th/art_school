package art.school;

import art.school.entity.Users;
import lombok.Getter;
import org.springframework.security.core.userdetails.User;

@Getter
public class AuthorizedUser extends User {

    private Integer id;

    public AuthorizedUser(Users user) {
        super(user.getEmail(), user.getPasswort(), user.getAktiv(), true, true, true, user.getRoles());
        this.id = user.getId();
    }
}

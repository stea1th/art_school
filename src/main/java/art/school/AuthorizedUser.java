package art.school;

import art.school.entity.Users;
import org.springframework.security.core.userdetails.User;

public class AuthorizedUser extends User {

    public AuthorizedUser(Users user) {
        super(user.getEmail(), user.getPasswort(), user.getAktiv(), true, true, true, user.getRoles());
    }
}

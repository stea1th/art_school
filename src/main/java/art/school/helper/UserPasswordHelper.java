package art.school.helper;


import art.school.entity.UserPassword;
import art.school.entity.Users;
import art.school.to.UserTo;
import art.school.util.PasswordGenerator;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserPasswordHelper {

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public UserPassword createUserPassword(UserTo to, Users user) {

        UserPassword u = new UserPassword();
        String adminPasswort = to.isEmpty() ? PasswordGenerator.generate() : to.getAdminPasswort();
        u.setAdminPasswort(adminPasswort);
        u.setGenerated(to.isEmpty());
        u.setPasswort(encoder.encode(adminPasswort));
        u.setRegistration(LocalDateTime.now());
        u.setUser(user);
        return u;
    }
}

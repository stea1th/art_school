package art.school.helper;


import art.school.entity.UserPassword;
import art.school.entity.Users;
import art.school.util.PasswordGenerator;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserPasswordHelper {

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public UserPassword createUserPassword(String adminPasswort, Users user) {
        boolean isGenerated = adminPasswort == null || "".equals(adminPasswort);
        return createUserPassword(isGenerated ? PasswordGenerator.generate() : adminPasswort, isGenerated, user);
    }

    public UserPassword createUserPassword(String adminPasswort, boolean isGenerated, Users user) {
        UserPassword u = new UserPassword();
        u.setAdminPasswort(adminPasswort);
        u.setGenerated(isGenerated);
        u.setPasswort(encoder.encode(adminPasswort));
        u.setRegistration(LocalDateTime.now());
        u.setUser(user);
        return u;
    }
}

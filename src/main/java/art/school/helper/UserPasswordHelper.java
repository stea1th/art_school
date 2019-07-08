package art.school.helper;


import art.school.entity.UserPassword;
import art.school.util.PasswordGenerator;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserPasswordHelper {

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public UserPassword createUserPassword(String adminPasswort) {
        boolean isGenerated = adminPasswort == null || "".equals(adminPasswort);
        return createUserPassword(isGenerated ? PasswordGenerator.generate() : adminPasswort, isGenerated);
    }

    public UserPassword createUserPassword(String adminPasswort, boolean isGenerated) {
        UserPassword u = new UserPassword();
        u.setAdminPasswort(adminPasswort);
        u.setGenerated(isGenerated);
        u.setPasswort(encoder.encode(adminPasswort));
        return u;
    }
}

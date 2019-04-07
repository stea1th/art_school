package art.school.to;

import art.school.entity.Role;
import art.school.entity.Users;
import art.school.util.FileHelper;
import art.school.util.RolesUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigInteger;
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
    private MultipartFile file;

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
                id, name, email, adresse, (adminPasswort == null || "".equals(adminPasswort))? "1" : adminPasswort, LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS), aktiv,
                RolesUtil.createRoles(Integer.parseInt(roles == null? "0" : roles))
        );
    }

    public Users updateUser(Users u){
        u.setName(name);
        u.setEmail(email);
        u.setAdresse(adresse);
        u.setAdminPasswort((adminPasswort == null || "".equals(adminPasswort))? "1" : adminPasswort);
        u.setAktiv(aktiv);
        u.setRoles(RolesUtil.createRoles(Integer.parseInt(roles == null? "0" : roles)));
        return u;
    }

    public Users updateProfile(Users u){
        u.setEmail(email);
        u.setAdresse(adresse);
        u.setAdminPasswort((adminPasswort == null || "".equals(adminPasswort))? u.getAdminPasswort() : adminPasswort);
        u.setImage(file == null? u.getImage() : FileHelper.convertFileToByteArray(file));
        return u;
    }

    public UserTo(Integer id, String name, String adresse, String email, String adminPasswort, String roles, Boolean aktiv, String registriert) {
        this.id = id;
        this.name = name;
        this.adresse = adresse;
        this.email = email;
        this.adminPasswort = adminPasswort;
        this.roles = roles;
        this.aktiv = aktiv;
        this.registriert = registriert;
    }

    public boolean isNew(){
        return id == null;
    }
}

package art.school.helper;

import art.school.entity.Role;
import art.school.entity.Users;
import art.school.to.UserTo;
import art.school.util.FileUtil;
import art.school.util.RolesUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserHelper {

    public UserTo createTo(Users u){
        UserTo to = new UserTo();

        to.setId(u.getId());
        to.setName(u.getName());
        to.setAdresse(u.getAdresse());
        to.setEmail(u.getEmail());
        to.setAdminPasswort(u.getAdminPasswort());
        to.setRoles(u.getRoles()
                .stream()
                .sorted((x1, x2) -> x2.ordinal()-x1.ordinal())
                .map(Role::getName)
                .findFirst().orElse(null));
        to.setAktiv(u.getAktiv());
        to.setRegistriert(u.getRegistriert().truncatedTo(ChronoUnit.SECONDS)
                .toString().replace("T", " "));
        to.setEncodedImage(FileUtil.convertByteArrayToString(u.getImage()));
        to.setIsAdmin(u.getRoles().stream().map(Role::getName).anyMatch(i-> i.equals("forum.admin")));

        return to;
    }

    public Users createUser(UserTo to) {
        Users u = updateUser(new Users(), to);
        u.setId(to.getId());
        u.setRegistriert(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
        return u;
    }

    public Users updateUser(Users u, UserTo to) {
        String adminPasswort = to.getAdminPasswort();

        u.setName(to.getName());
        u.setEmail(to.getEmail());
        u.setAdresse(to.getAdresse());
        u.setAdminPasswort((adminPasswort == null || "".equals(adminPasswort)) ? "1" : adminPasswort);
        u.setAktiv(to.getAktiv());
        u.setRoles(RolesUtil.createRoles(Integer.parseInt(to.getRoles() == null ? "0" : to.getRoles())));
        return u;
    }

    public Users updateProfile(Users u, UserTo to) {
        String adminPasswort = to.getAdminPasswort();
        MultipartFile file = to.getFile();
        u.setEmail(to.getEmail());
        u.setAdresse(to.getAdresse());
        u.setAdminPasswort((adminPasswort == null || "".equals(adminPasswort)) ? u.getAdminPasswort() : adminPasswort);
        u.setImage(file != null ? FileUtil.convertFileToByteArray(file) : to.getRemoveImage() ? null : u.getImage());

        return u;
    }

    public List<UserTo> transformTos(List<Users> list){
        return list.stream().map(this::createTo)
                .collect(Collectors.toList());
    }
}
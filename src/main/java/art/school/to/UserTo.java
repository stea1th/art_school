package art.school.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

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
    private String encodedImage;
    private Boolean removeImage;
    private Boolean isAdmin;

    public boolean isNew() {
        return id == null;
    }

    public boolean isEmpty() {
        return adminPasswort == null || "".equals(adminPasswort);
    }
}

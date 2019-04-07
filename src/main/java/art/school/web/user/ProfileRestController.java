package art.school.web.user;

import art.school.to.UserTo;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/profile")
@Secured("ROLE_USER")
public class ProfileRestController extends AbstractUserController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public UserTo getProfile() {
        return super.getToForProfile();
    }

    @PostMapping(value= "/save", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void saveProfile(UserTo userTo){
        super.updateProfile(userTo);
    }

    @GetMapping(value = "/my-image")
    public String getMyImage(){
        return super.getMyImage();
    }

}

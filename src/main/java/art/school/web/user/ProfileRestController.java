package art.school.web.user;

import art.school.to.UserTo;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Arrays;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/profile")
@Secured("ROLE_USER")
public class ProfileRestController extends AbstractUserController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public UserTo getProfile() {
        return super.getToForProfile();
    }

    @PostMapping(value= "/save", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void saveProfile(@RequestParam(value= "file")MultipartFile file){
        System.out.println("Hallo1");
        System.out.println(file.getOriginalFilename());
    }

}

package art.school.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

    @GetMapping("/")
    public String root(){
        return "redirect:forum";
    }

    @GetMapping("/unterricht")
    public String unterricht(){
        return "unterricht";
    }

    @GetMapping("/kind")
    public String kinder(){
        return "kind";
    }

    @GetMapping("/zahlung")
    public String zahlung() { return "zahlung";}

    @GetMapping("/statistik")
    public String statistik() { return "statistik";}

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

}

package art.school.web;

import art.school.web.unterricht.AbstractUnterrichtController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController extends AbstractUnterrichtController {

    @GetMapping("/")
    public String root(){
        return "redirect:unterricht";
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

}

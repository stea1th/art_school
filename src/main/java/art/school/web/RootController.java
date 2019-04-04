package art.school.web;

import art.school.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RootController {

    @Autowired
    private Messages messages;

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

    @GetMapping(value = "/api/locale")
    @ResponseBody
    public String getLocale(){
        return LocaleContextHolder.getLocale().toString();
    }

    @GetMapping(value = "/api/locale/tables")
    @ResponseBody
    public String getLocaleForTables(){
        System.out.println(messages.get("datatables.lang"));
        return messages.get("datatables.lang");
    }

}

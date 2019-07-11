package art.school.web;

import art.school.service.UserPasswordService;
import art.school.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RootController {

    @Autowired
    private Messages message;

    @Autowired
    private UserPasswordService userPasswordService;

    @GetMapping("/")
    public String root() {
        if (userPasswordService.getLatestByUserId(SecurityUtil.getAuthId()).isGenerated()) {
            return "redirect:profile";
        }
        return "redirect:forum";
    }

    @GetMapping("/unterricht")
    public String unterricht() {
        return "unterricht";
    }

    @GetMapping("/kind")
    public String kinder() {
        return "kind";
    }

    @GetMapping("/zahlung")
    public String zahlung() {
        return "zahlung";
    }

    @GetMapping("/statistik")
    public String statistik() {
        return "statistik";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/profile")
    public String profile() {
        return "profile";
    }

    @GetMapping(value = "/api/locale")
    @ResponseBody
    public String getLocale() {
        return LocaleContextHolder.getLocale().toString();
    }

    @GetMapping(value = "/api/locale/tables")
    @ResponseBody
    public String getLocaleForTables() {
        return message.get("datatables.lang");
    }

}

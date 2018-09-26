package art.school.web;


import art.school.entity.Kind;
import art.school.service.KindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class KindController {

    @Autowired
    KindService kindService;

    public Kind get(int id){
        return kindService.get(id);
    }
}

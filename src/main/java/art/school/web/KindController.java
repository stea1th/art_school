package art.school.web;


import art.school.entity.Kind;
import art.school.service.KindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class KindController {

    @Autowired
    KindService kindService;

    public Kind get(int id){
        return kindService.get(id);
    }

    public Kind create(Kind kind){
        return kindService.create(kind);
    }

    public void delete(int id){
        kindService.delete(id);
    }

    public void toggleAktiv(int id){
        kindService.toggleAktiv(id);
    }



    public void update(Kind kind){
        kindService.update(kind);
    }

    public List<Kind> getAll(){
        return kindService.getAll();
    }
}
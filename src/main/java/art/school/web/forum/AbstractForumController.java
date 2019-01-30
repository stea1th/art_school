package art.school.web.forum;

import art.school.entity.Thema;
import art.school.service.ThemaService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class AbstractForumController {

    @Autowired
    private ThemaService themaService;

    public List<Thema> getAll(){
        return themaService.getAll();
    }

}

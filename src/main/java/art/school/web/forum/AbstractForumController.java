package art.school.web.forum;

import art.school.entity.Thema;
import art.school.service.ThemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public abstract class AbstractForumController {

    @Autowired
    private ThemaService themaService;

    public List<Thema> getAll(){
        return themaService.getAll();
    }

    public Thema get(int id) {
        return themaService.get(id);
    }

    public Page<Thema> getAll(Pageable pageable){
        return themaService.getAll(pageable);
    }

}

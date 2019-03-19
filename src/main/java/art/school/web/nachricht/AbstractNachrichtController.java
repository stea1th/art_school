package art.school.web.nachricht;

import art.school.entity.Nachricht;
import art.school.service.NachrichtService;
import art.school.to.NachrichtTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class AbstractNachrichtController {

    @Autowired
    private NachrichtService nachrichtService;

    public List<Nachricht> getAllByThemaId(int themaId){
        return nachrichtService.getAllByThemaId(themaId);
    }

    public Page<Nachricht> getPageByThemaId(int id, Pageable pageable){
        return nachrichtService.getPageByThemaId(id, pageable);
    }

    public Nachricht get(int id){
        return nachrichtService.get(id);
    }

    public Nachricht create(Nachricht nachricht){
        return nachrichtService.create(nachricht);
    }

    public Nachricht createNachrichtWithUpdaters(Integer id, String action){
        return nachrichtService.createNachrichtWithUpdaters(id, action);
    }

    public List<NachrichtTo> getAllTos(int id, Pageable pageable){
        return nachrichtService.getAllTos(id, pageable);
    }
}

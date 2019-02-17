package art.school.web.nachricht;

import art.school.entity.Nachricht;
import art.school.service.NachrichtService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AbstractNachrichtController {

    @Autowired
    private NachrichtService nachrichtService;

    public List<Nachricht> getAllByThemaId(int themaId){
        return nachrichtService.getAllByThemaId(themaId);
    }

    public Nachricht get(int id){
        return nachrichtService.get(id);
    }

    public Nachricht create(Nachricht nachricht){
        return nachrichtService.create(nachricht);
    }
}
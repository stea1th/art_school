package art.school.service;

import art.school.entity.Nachricht;
import art.school.to.NachrichtTo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface NachrichtService extends MainServiceInterface<Nachricht> {

    List<Nachricht> getAllByThemaId(int id);

    Page<Nachricht> getPageByThemaId(int id, Pageable pageable);

    Nachricht createNachrichtWithUpdaters(Integer id, String action);

    List<NachrichtTo> getAllTos(int id, Pageable pageable);
}

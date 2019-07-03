package art.school.service;

import art.school.entity.Nachricht;
import art.school.to.NachrichtTo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface NachrichtService extends MainServiceInterface<Nachricht> {

    List<Nachricht> getAllByThemaId(int id);

    Page<Nachricht> getPageByThemaId(int id, Pageable pageable);

    Nachricht createNachrichtWithUpdaters(Integer id, String action);

    List<NachrichtTo> getAllTosByThema(int id, Pageable pageable);

    List<NachrichtTo> getAllTosByThema(int id);

    List<NachrichtTo> getAllTos();

    Long count();

    NachrichtTo getTo(int id);

    Map<List<NachrichtTo>, Page<Nachricht>> getAllTosAsMap(int id, Pageable pageable);

    NachrichtTo getTo(int id, int page, boolean reload);
}

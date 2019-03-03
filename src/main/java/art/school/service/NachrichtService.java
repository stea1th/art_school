package art.school.service;

import art.school.entity.Nachricht;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface NachrichtService extends MainServiceInterface<Nachricht> {

    List<Nachricht> getAllByThemaId(int id);

    Page<Nachricht> getPageByThemaId(int id, Pageable pageable);
}

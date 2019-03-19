package art.school.service;

import art.school.entity.Thema;
import art.school.to.ThemaTo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ThemaService extends MainServiceInterface<Thema> {

    Page<Thema> getAll(Pageable pageable);

    List<ThemaTo> getAllTos(Pageable pageable);
}

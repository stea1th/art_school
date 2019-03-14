package art.school.service;

import art.school.entity.Thema;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ThemaService extends MainServiceInterface<Thema> {

    Page<Thema> getAll(Pageable pageable);
}

package art.school.repository;

import art.school.entity.Thema;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ThemaRepository extends MainRepoInterface<Thema>{
    Page<Thema> getAll(Pageable pageable);
    long count();
}

package art.school.service;

import art.school.entity.Thema;
import art.school.to.ThemaTo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface ThemaService extends MainServiceInterface<Thema> {

    Page<Thema> getAll(Pageable pageable);

    Map<List<ThemaTo>, Page<Thema>> getAllTosAsMap(Pageable pageable);

    List<ThemaTo> getAllTos();

    List<ThemaTo> getAllTos(Pageable pageable);

    ThemaTo getTo(int id);

    long count();

    void attach(int id);
}

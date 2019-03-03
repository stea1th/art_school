package art.school.repository.datajpa;

import art.school.entity.Nachricht;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface CrudNachrichtRepository extends JpaRepository<Nachricht, Integer> {

    @NotNull
    List<Nachricht> findAllByThemaId(@NotNull Integer id);

    Page<Nachricht> findAllByThemaId(@NotNull Integer id, Pageable pageable);

    Optional<Nachricht> findById(int id);
}

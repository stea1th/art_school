package art.school.repository.datajpa;

import art.school.entity.Thema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@Transactional(readOnly = true)
public interface CrudThemaRepository extends JpaRepository<Thema, Integer> {

    @NotNull
    @Override
    Optional<Thema> findById(@NotNull Integer id);

    @Transactional
    @Modifying
    @Query("DELETE FROM Thema t WHERE t.id=:id")
    int delete(@Param("id") int id);
}

package art.school.repository.datajpa;

import art.school.entity.Kind;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
public interface CrudKindRepository extends JpaRepository<Kind, Integer> {


    @NotNull
    @Override
    Optional<Kind> findById(@NotNull Integer id);

    @Transactional
    @Modifying
    @Query("DELETE FROM Kind k WHERE k.id=:id")
    int delete(@Param("id") int id);
}

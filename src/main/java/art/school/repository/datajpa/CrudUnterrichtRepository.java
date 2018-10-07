package art.school.repository.datajpa;

import art.school.entity.Unterricht;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
public interface CrudUnterrichtRepository extends JpaRepository<Unterricht, Integer> {
    @NotNull
    @Override
    Optional<Unterricht> findById(@NotNull Integer id);

    @Transactional
    @Modifying
    @Query("DELETE FROM Unterricht u WHERE u.id=:id")
    int delete(@Param("id") int id);
}

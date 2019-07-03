package art.school.repository.datajpa;

import art.school.entity.Zahlung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface CrudZahlungRepository extends JpaRepository<Zahlung, Integer> {

    @NotNull
    @Override
    Optional<Zahlung> findById(@NotNull Integer id);

    @Transactional
    @Modifying
    @Query("DELETE FROM Zahlung z WHERE z.id=:id")
    int delete(@Param("id") int id);

    List<Zahlung> findAllByAktivIsTrue();
}

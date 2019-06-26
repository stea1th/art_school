package art.school.repository.datajpa;

import art.school.entity.Unterricht;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
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

    @Query(value = "select distinct substring(CONCAT(u.datum, \'\'), 1, 4) from Unterricht u ", nativeQuery = true)
    List<String> getYears();

    //    @Query(value = "select * from Unterricht u where extract(year from u.datum) = 2019 ", nativeQuery = true)
//    List<Unterricht> getAllByYear( int year);
    @Transactional
    @Modifying
    List<Unterricht> findAllByDatumIsBetween(LocalDateTime after, LocalDateTime before);
}

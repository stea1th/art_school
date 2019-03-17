package art.school.repository.datajpa;

import art.school.entity.Thema;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.List;
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


    @Query(value = "select t from Thema t \n" +
            "left join t.nachrichts n \n" +
            "group by t.id \n" +
            "order by t.gepinnt desc , max(n.datum) desc ",
            countQuery = "select count(t) from Thema t \n" +
                    "left join t.nachrichts n \n" +
                    "group by t.id \n" +
                    "order by t.gepinnt desc , max(n.datum) desc ")
    Page<Thema> findAllThis(Pageable pageable);

    @Query(value = "select t from Thema t \n" +
            "left join t.nachrichts n \n" +
            "group by t.id \n" +
            "order by t.gepinnt desc , max(n.datum) desc ")
    List<Thema> findAllAsList();
}

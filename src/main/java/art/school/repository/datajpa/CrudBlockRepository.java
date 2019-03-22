package art.school.repository.datajpa;

import art.school.entity.Block;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface CrudBlockRepository extends JpaRepository<Block, Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Block b WHERE b.id=:id")
    int delete(@Param("id") int id);

    List<Block> findAllByUserId(int id);

    @Transactional
    @Query(value = "select b.* from block b\n" +
            "left join users u on b.u_id = u.id\n" +
            "where u.id = ?1 and now() < b.datum\n" +
            "order by b.datum desc\n" +
            "limit 1", nativeQuery = true)
    Block findLatestByUserId(int id);


}

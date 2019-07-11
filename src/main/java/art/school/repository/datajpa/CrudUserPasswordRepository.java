package art.school.repository.datajpa;

import art.school.entity.UserPassword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface CrudUserPasswordRepository extends JpaRepository<UserPassword, Integer> {


    @Query(value = "select u\n" +
            "from UserPassword u\n" +
            "where u.user.id = :userId\n" +
            "  and u.registration =\n" +
            "      (select max(u2.registration)\n" +
            "       from UserPassword u2\n" +
            "       where u2.user.id = u.user.id)")
    UserPassword findLatestByUserId(@Param("userId") int userId);


    @Transactional
    @Modifying
    @Query("DELETE FROM UserPassword u WHERE u.id=:id")
    int delete(@Param("id") int id);

    @Query(value = "select u\n" +
            "from UserPassword u\n" +
            "where u.user.id = :userId\n")
    List<UserPassword> findAllByUserId(@Param("userId") int userId);
}

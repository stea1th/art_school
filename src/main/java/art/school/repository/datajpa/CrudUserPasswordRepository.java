package art.school.repository.datajpa;

import art.school.entity.UserPassword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface CrudUserPasswordRepository extends JpaRepository<UserPassword, Integer> {


    @Query(value = "select u from UserPassword u where u.user.id = :userId and u.registration = max(u.registration)")
    UserPassword findLatestByUserId(@Param("userId") int userId);


    @Transactional
    @Modifying
    @Query("DELETE FROM UserPassword u WHERE u.id=:id")
    int delete(@Param("id") int id);
}

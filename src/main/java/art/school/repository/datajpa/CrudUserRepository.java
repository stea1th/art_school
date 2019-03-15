package art.school.repository.datajpa;

import art.school.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface CrudUserRepository extends JpaRepository<Users, Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Users u WHERE u.id=:id")
    int delete(@Param("id") int id);

    Users findUsersByEmail(String email);

    @Override
    @NotNull
    Optional<Users> findById(Integer id);

    @Query(value = "select * from users u\n" +
            "where u.id not in (\n" +
            "select u.id from users u\n" +
            "left join user_roles role2 on u.id = role2.user_id\n" +
            "where role2.role = 'ROLE_ADMIN' or role2.role = 'ROLE_MODERATOR')\n" +
            "order by u.name asc", nativeQuery = true)
    List<Users> findKinds();
}

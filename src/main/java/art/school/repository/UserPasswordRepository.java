package art.school.repository;

import art.school.entity.UserPassword;

import java.util.List;

public interface UserPasswordRepository extends MainRepoInterface<UserPassword> {

    UserPassword getLatestByUserId(int userId);

    List<UserPassword> getAllByUserId(int userId);

}

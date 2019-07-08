package art.school.repository;

import art.school.entity.UserPassword;

public interface UserPasswordRepository extends MainRepoInterface<UserPassword> {

    UserPassword getLatestByUserId(int userId);

}

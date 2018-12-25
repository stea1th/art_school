package art.school.repository;

import art.school.entity.Users;

public interface UserRepository extends MainRepoInterface<Users> {

    Users getUsersByEmail(String email);

}

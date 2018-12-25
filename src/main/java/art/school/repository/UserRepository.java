package art.school.repository;

import art.school.entity.User;

public interface UserRepository extends MainRepoInterface<User> {

    User getByEmail(String email);

}

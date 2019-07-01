package art.school.repository;

import art.school.entity.Users;

import java.util.List;

public interface UserRepository extends MainRepoInterface<Users> {

    Users getUsersByEmail(String email);

    List<Users> getAllKids();

    List<Users> getOnlyActiveKids();
}

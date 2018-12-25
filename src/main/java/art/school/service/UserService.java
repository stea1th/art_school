package art.school.service;

import art.school.entity.Users;


public interface UserService extends MainServiceInterface<Users> {

    void toggleAktiv(int id);

    Users getUsersByEmail(String email);
}

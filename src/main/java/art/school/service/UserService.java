package art.school.service;

import art.school.entity.User;


public interface UserService extends MainServiceInterface<User> {

    void toggleAktiv(int id);

    User getUserByEmail(String email);
}

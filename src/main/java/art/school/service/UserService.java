package art.school.service;

import art.school.entity.Users;

import java.util.List;


public interface UserService extends MainServiceInterface<Users> {

    void toggleAktiv(int id);

    Users getUsersByEmail(String email);

    List<Users> getAllKinds();
}

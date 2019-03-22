package art.school.service;

import art.school.entity.Users;
import art.school.to.UserTo;

import java.util.List;


public interface UserService extends MainServiceInterface<Users> {

    void toggleAktiv(int id);

    Users getUsersByEmail(String email);

    List<UserTo> getAllKinds();

    List<UserTo> getAllTos();

    UserTo getUserTo(int id);

    boolean isUserBanned(int id);
}

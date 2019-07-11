package art.school.service;

import art.school.entity.UserPassword;

import java.util.Map;

public interface UserPasswordService extends MainServiceInterface<UserPassword> {

    UserPassword getLatestByUserId(int userId);

    Map<String, UserPassword> getMapWithAllByUserId(int userId);
}

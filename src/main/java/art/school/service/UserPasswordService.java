package art.school.service;

import art.school.entity.UserPassword;

public interface UserPasswordService extends MainServiceInterface<UserPassword> {

    UserPassword getLatestByUserId(int userId);
}

package art.school.service;

import art.school.entity.Block;
import art.school.entity.Users;
import art.school.to.BlockTo;
import art.school.to.UserTo;

import java.util.List;


public interface UserService extends MainServiceInterface<Users> {

    void toggleAktiv(int id);

    Users getUsersByEmail(String email);

    void updateProfile(UserTo userTo);

    List<UserTo> getAllKids();

    List<UserTo> getAllTos();

    UserTo getUserTo(int id);

    boolean isUserBanned(int id);

    void createBlockForUserWithTo(BlockTo block, int id);

    BlockTo checkIfBlocked();

    void accepted();

    void unblockUser(int id);

    String getImage(int authId);

    List<UserTo> getOnlyActiveKids();
}

package art.school.web.user;

import art.school.entity.Users;
import art.school.service.UserService;
import art.school.to.BlockTo;
import art.school.to.UserTo;
import art.school.web.SecurityUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
public abstract class AbstractUserController  {

    @Autowired
    private UserService service;


    void accepted(){
        service.accepted();
    }

    void blockUser(BlockTo block, int id){
        service.createBlockForUserWithTo(block, id);
    }

    public UserTo getToForProfile(){
        return service.getUserTo(SecurityUtil.getAuthId());
    }

    public Users get(int id) {
        log.info("get Users {}", id);
        return service.get(id);
    }

    public Users create(Users users){
        log.info("create Users {}", users);
        return service.create(users);
    }

    public void delete(int id){
        log.info("delete Users {}", id);
        service.delete(id);
    }

    void toggleAktiv(int id){
        log.info("toggle Users {} Status", id);
        service.toggleAktiv(id);
    }

    public List<Users> getAll(){
        log.info("getAll Users");
        return service.getAll();
    }

    List<UserTo> getAllKinds(){
        log.info("getAll Kinds");
        return service.getAllKinds();
    }

    public List<UserTo> getAllTos(){
        return service.getAllTos();
    }

    UserTo getUserTo(int id){
        return service.getUserTo(id);
    }

    BlockTo checkIfBlocked() {
        return service.checkIfBlocked();
    }

    void unblockUser(int id){
        service.unblockUser(id);
    }

    void updateProfile(UserTo userTo){
        service.updateProfile(userTo);
    }

}

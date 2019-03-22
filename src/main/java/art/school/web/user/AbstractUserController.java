package art.school.web.user;

import art.school.entity.Users;
import art.school.service.UserService;
import art.school.to.UserTo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
public abstract class AbstractUserController  {

    @Autowired
    private UserService service;

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

    public UserTo getUserTo(int id){
        return service.getUserTo(id);
    }

}

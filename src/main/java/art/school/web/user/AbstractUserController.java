package art.school.web.user;

import art.school.entity.Users;
import art.school.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static art.school.util.ValidationUtil.assureIdConsistent;
import static art.school.util.ValidationUtil.checkNew;

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
        checkNew(users);
        return service.create(users);
    }

    public void delete(int id){
        log.info("delete Users {}", id);
        service.delete(id);
    }

    public void toggleAktiv(int id){
        log.info("toggle Users {} Status", id);
        service.toggleAktiv(id);
    }

    public void update(Users users, int id){
        log.info("update {} with id={}", users, id);
        assureIdConsistent(users, id);
        service.update(users);
    }

    public List<Users> getAll(){
        log.info("getAll Users");
        return service.getAll();
    }

    public List<Users> getAllKinds(){
        log.info("getAll Kinds");
        return service.getAllKinds();
    }
}

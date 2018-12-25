package art.school.web.user;

import art.school.entity.User;
import art.school.service.UserService;
import art.school.util.ValidationUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static art.school.util.ValidationUtil.assureIdConsistent;
import static art.school.util.ValidationUtil.checkNew;

@Slf4j
public abstract class AbstractUserController  {

    @Autowired
    private UserService service;

    public User get(int id) {
        log.info("get User {}", id);
        return service.get(id);
    }

    public User create(User user){
        log.info("create User {}", user);
        checkNew(user);
        return service.create(user);
    }

    public void delete(int id){
        log.info("delete User {}", id);
        service.delete(id);
    }

    public void toggleAktiv(int id){
        log.info("toggle User {} Status", id);
        service.toggleAktiv(id);
    }

    public void update(User user, int id){
        log.info("update {} with id={}", user, id);
        assureIdConsistent(user, id);
        service.update(user);
    }

    public List<User> getAll(){
        log.info("getAll Users");
        return service.getAll();
    }
}

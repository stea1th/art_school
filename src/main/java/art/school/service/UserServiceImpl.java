package art.school.service;

import art.school.entity.User;
import art.school.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

import static art.school.util.ValidationUtil.checkNotFoundWithId;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    @Transactional
    public void toggleAktiv(int id) {
        User user = get(id);
        user.setAktiv(!user.getAktiv());
    }

    @Override
    public User getUserByEmail(String email) {
        return repository.getByEmail(email);
    }

    @Override
    public User create(User user) {
        Assert.notNull(user, "user must not be null");
        return repository.save(user);
    }

    @Override
    public void delete(int id) {
        checkNotFoundWithId(repository.delete(id), id);
    }

    @Override
    public User get(int id) {
        return checkNotFoundWithId(repository.get(id), id);
    }

    @Override
    public void update(User user) {
        Assert.notNull(user, "user must not be null");
        checkNotFoundWithId(repository.save(user), user.getId());

    }

    @Override
    public List<User> getAll() {
        return repository.getAll();
    }
}

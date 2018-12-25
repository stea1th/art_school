package art.school.service;

import art.school.AuthorizedUser;
import art.school.entity.Users;
import art.school.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

import static art.school.util.ValidationUtil.checkNotFoundWithId;

@Service("userService")
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository repository;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    @Transactional
    public void toggleAktiv(int id) {
        Users users = get(id);
        users.setAktiv(!users.getAktiv());
    }

    @Override
    public Users getUsersByEmail(String email) {
        return repository.getUsersByEmail(email);
    }


    @Override
    public Users create(Users users) {
        Assert.notNull(users, "users must not be null");
        return repository.save(users);
    }

    @Override
    public void delete(int id) {
        checkNotFoundWithId(repository.delete(id), id);
    }

    @Override
    public Users get(int id) {
        return checkNotFoundWithId(repository.get(id), id);
    }

    @Override
    public void update(Users users) {
        Assert.notNull(users, "users must not be null");
        checkNotFoundWithId(repository.save(users), users.getId());
    }

    @Override
    public List<Users> getAll() {
        return repository.getAll();
    }

    @Override
    public AuthorizedUser loadUserByUsername(String email) throws UsernameNotFoundException {
        Users users = repository.getUsersByEmail(email);
        if(users == null){
            throw new UsernameNotFoundException("Users " + email +" is not found");
        }
        return new AuthorizedUser(users);
    }
}

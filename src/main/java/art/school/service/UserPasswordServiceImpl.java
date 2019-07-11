package art.school.service;

import art.school.entity.UserPassword;
import art.school.repository.UserPasswordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserPasswordServiceImpl implements UserPasswordService {

    @Autowired
    private UserPasswordRepository userPasswordRepository;

    @Override
    public UserPassword getLatestByUserId(int userId) {
        return userPasswordRepository.getLatestByUserId(userId);
    }

    @Override
    public Map<String, UserPassword> getMapWithAllByUserId(int userId) {
        return userPasswordRepository.getAllByUserId(userId)
                .stream()
                .collect(Collectors.toMap(UserPassword::getAdminPasswort, i -> i));
    }

    @Override
    @Transactional
    public UserPassword create(UserPassword userPassword) {
        return userPasswordRepository.save(userPassword);
    }

    @Override
    public void delete(int id) {
        userPasswordRepository.delete(id);
    }

    @Override
    public UserPassword get(int id) {
        return userPasswordRepository.get(id);
    }

    @Override
    public void update(UserPassword userPassword) {

    }

    @Override
    public List<UserPassword> getAll() {
        return userPasswordRepository.getAll();
    }
}

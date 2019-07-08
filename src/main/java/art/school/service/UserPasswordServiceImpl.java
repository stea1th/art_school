package art.school.service;

import art.school.entity.UserPassword;
import art.school.repository.UserPasswordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserPasswordServiceImpl implements UserPasswordService {

    @Autowired
    private UserPasswordRepository userPasswordRepository;

//    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public UserPassword getLatestByUserId(int userId) {
        return userPasswordRepository.getLatestByUserId(userId);
    }

    @Override
    @Transactional
    public UserPassword create(UserPassword userPassword) {
//        userPassword.setPasswort(encoder.encode(userPassword.getAdminPasswort()));
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

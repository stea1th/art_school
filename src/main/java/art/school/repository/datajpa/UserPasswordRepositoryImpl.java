package art.school.repository.datajpa;

import art.school.entity.UserPassword;
import art.school.repository.UserPasswordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserPasswordRepositoryImpl implements UserPasswordRepository {

    @Autowired
    private CrudUserPasswordRepository repository;

    @Override
    public UserPassword save(UserPassword userPassword) {
        return repository.save(userPassword);
    }

    @Override
    public boolean delete(int id) {
        return repository.delete(id) != 0;
    }

    @Override
    public UserPassword get(int id) {
        return repository.getOne(id);
    }

    @Override
    public List<UserPassword> getAll() {
        return repository.findAll();
    }

    @Override
    public UserPassword getLatestByUserId(int userId) {
        return repository.findLatestByUserId(userId);
    }
}

package art.school.repository.datajpa;

import art.school.entity.Users;
import art.school.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private CrudUserRepository repository;

    @Override
    @Transactional
    public Users save(Users users) {
        return repository.save(users);
    }

    @Override
    public boolean delete(int id) {
        return repository.delete(id) != 0;
    }

    @Override
    public Users get(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Users> getAll() {
        return repository.findAll();
    }

    public List<Users> getAllKids(){
        return repository.findKids();
    }

    @Override
    public List<Users> getOnlyActiveKids() {
        return repository.findOnlyActiveKids();
    }

    @Override
    public Users getUsersByEmail(String email) {
        return repository.findUsersByEmail(email);
    }

}

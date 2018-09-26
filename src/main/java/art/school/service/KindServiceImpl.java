package art.school.service;

import art.school.entity.Kind;
import art.school.repository.KindRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KindServiceImpl implements KindService {

    @Autowired
    KindRepository repository;

    @Override
    public Kind get(int id) {
        return repository.get(id);
    }
}

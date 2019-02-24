package art.school.service;

import art.school.entity.NachrichtUpdater;
import art.school.entity.NachrichtUpdaterId;
import art.school.repository.NachrichtUpdaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NachrichtUpdaterServiceImpl implements NachrichtUpdaterService {

    @Autowired
    private NachrichtUpdaterRepository repository;

    @Override
    public NachrichtUpdater save(NachrichtUpdater nachrichtUpdater) {
        return repository.save(nachrichtUpdater);
    }
}

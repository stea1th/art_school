package art.school.repository.datajpa;

import art.school.entity.Block;
import art.school.repository.BlockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class BlockRepositoryImpl implements BlockRepository {


    @Autowired
    private CrudBlockRepository repository;

    @Override
    @Transactional
    public Block save(Block block) {
        return repository.save(block);
    }

    @Override
    public boolean delete(int id) {
        return repository.delete(id) != 0;
    }

    @Override
    public Block get(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Block> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Block> getAllByUserId(int id) {
        return repository.findAllByUserId(id);
    }

    @Override
    public Block getLatestByUserId(int id) {
        return repository.findLatestByUserId(id);
    }

    @Override
    public Block getLatestByUserIdAndByNotAccepted(int id){
        return repository.findLatestByUserIdAndByAccepted(id, false);
    }

    @Override
    public Block getLatestByUserIdAndByAccepted(int id, boolean accepted){
        return repository.findLatestByUserIdAndByAccepted(id, accepted);
    }


}

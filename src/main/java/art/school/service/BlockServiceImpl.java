package art.school.service;

import art.school.entity.Block;
import art.school.entity.Users;
import art.school.repository.BlockRepository;
import art.school.repository.UserRepository;
import art.school.to.BlockTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlockServiceImpl implements BlockService {

    @Autowired
    private BlockRepository blockRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Block findLatestByUserId(int id) {
        return blockRepository.getLatestByUserId(id);
    }

    @Override
    public Block createWithTo(BlockTo block, int id) {

        return create(block.createBlock(userRepository.get(id)));
    }

    @Override
    public Block create(Block block) {
        return blockRepository.save(block);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Block get(int id) {
        return null;
    }

    @Override
    public void update(Block block) {

    }

    @Override
    public List<Block> getAll() {
        return null;
    }
}

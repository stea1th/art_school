package art.school.repository;

import art.school.entity.Block;

import java.util.List;

public interface BlockRepository extends MainRepoInterface<Block> {

    List<Block> getAllByUserId(int id);

    Block getLatestByUserId(int id);
}

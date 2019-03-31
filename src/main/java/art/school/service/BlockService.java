package art.school.service;

import art.school.entity.Block;
import art.school.to.BlockTo;

public interface BlockService extends MainServiceInterface<Block> {

    Block findLatestByUserId(int id);

    Block createWithTo(BlockTo block, int id);
}

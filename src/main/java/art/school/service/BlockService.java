package art.school.service;

import art.school.entity.Block;

public interface BlockService extends MainServiceInterface<Block> {

    Block findLatestByUserId(int id);
}

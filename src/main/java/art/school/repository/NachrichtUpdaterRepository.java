package art.school.repository;

import art.school.entity.NachrichtUpdater;
import art.school.entity.NachrichtUpdaterId;

public interface NachrichtUpdaterRepository {

    NachrichtUpdater save(NachrichtUpdater nachrichtUpdater);

    NachrichtUpdater get(NachrichtUpdaterId updaterId);

    void delete(NachrichtUpdater nachrichtUpdater);
}

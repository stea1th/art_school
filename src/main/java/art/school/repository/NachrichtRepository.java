package art.school.repository;

import art.school.entity.Nachricht;

import java.util.List;

public interface NachrichtRepository extends MainRepoInterface<Nachricht>{

    List<Nachricht> getAllByThemaId(int id);
}

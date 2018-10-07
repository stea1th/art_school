package art.school.repository;

import art.school.entity.Unterricht;

public interface UnterrichtRepository extends MainRepoInterface<Unterricht> {

    Unterricht save(Unterricht unterricht, Integer... ids);
}

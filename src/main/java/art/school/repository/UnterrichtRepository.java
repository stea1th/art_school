package art.school.repository;

import art.school.entity.Unterricht;

import java.util.List;
import java.util.Set;

public interface UnterrichtRepository extends MainRepoInterface<Unterricht> {

    Unterricht save(Unterricht unterricht, Integer... ids);

    List<String> getYears();

    List<Unterricht> getAllByYear(int year);
}

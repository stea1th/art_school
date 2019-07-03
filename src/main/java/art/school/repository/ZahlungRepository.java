package art.school.repository;

import art.school.entity.Zahlung;

import java.util.List;

public interface ZahlungRepository extends MainRepoInterface<Zahlung> {

    List<Zahlung> getOnlyAktiv();

}

package art.school.service;

import art.school.entity.Zahlung;
import art.school.to.ZahlungTo;

import java.util.List;

public interface ZahlungService extends MainServiceInterface<Zahlung>{
    boolean toggleAktiv(int id);

    List<ZahlungTo> getAllTos();

    ZahlungTo getTo(int id);

    List<ZahlungTo> onlyAktiv();
}

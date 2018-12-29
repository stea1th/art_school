package art.school.service;

import art.school.entity.Unterricht;

public interface UnterrichtService extends MainServiceInterface<Unterricht> {

    Unterricht create(Unterricht unterricht, Integer... arr);

    void toggleBezahlt(int id);


}

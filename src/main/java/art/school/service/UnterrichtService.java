package art.school.service;

import art.school.entity.Unterricht;
import art.school.to.RequestUnterrichtTo;

public interface UnterrichtService extends MainServiceInterface<Unterricht> {

    Unterricht create(Unterricht unterricht, Integer... arr);

    void toggleBezahlt(int id);

    Unterricht createFromTo(RequestUnterrichtTo unterrichtTo);

    void updateFromTo(RequestUnterrichtTo unterrichtTo);

    RequestUnterrichtTo createRequestUnterrichtTo(int id);


}

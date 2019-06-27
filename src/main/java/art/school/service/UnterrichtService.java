package art.school.service;

import art.school.entity.Unterricht;
import art.school.statik.MonthForStatistik;
import art.school.to.RequestUnterrichtTo;
import art.school.to.UnterrichtTo;

import java.util.List;

public interface UnterrichtService extends MainServiceInterface<Unterricht> {

    Unterricht create(Unterricht unterricht, Integer... arr);

    void toggleBezahlt(int id);

    Unterricht createFromTo(RequestUnterrichtTo unterrichtTo);

    void updateFromTo(RequestUnterrichtTo unterrichtTo);

    RequestUnterrichtTo createRequestUnterrichtTo(int id);

    List<UnterrichtTo> getAllTos();

    List<String> getYears();

    List<Unterricht> getAllByYear(int year);

    List<MonthForStatistik> getStatistik(int year);
}

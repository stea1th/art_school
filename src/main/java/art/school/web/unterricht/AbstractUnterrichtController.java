package art.school.web.unterricht;

import art.school.entity.Unterricht;
import art.school.service.UnterrichtService;
import art.school.statik.MonthForStatistik;
import art.school.to.RequestUnterrichtTo;
import art.school.to.UnterrichtTo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static art.school.util.DateUtil.splitAndParseStrings;


@Slf4j
public abstract class AbstractUnterrichtController {

    @Autowired
    private UnterrichtService unterrichtService;

    public Unterricht get(int id) {
        log.info("get Unterricht {}", id);
        return unterrichtService.get(id);
    }

    public Unterricht create(RequestUnterrichtTo unterrichtTo) {
        log.info("create {} for Users {} and Zahlung {}", unterrichtTo, unterrichtTo.getKind(), unterrichtTo.getZahlung());
        return unterrichtService.createFromTo(unterrichtTo);
    }

    public void delete(int id) {
        log.info("delete Unterricht {}", id);
        unterrichtService.delete(id);
    }

    public void update(RequestUnterrichtTo unterrichtTo) {
        log.info("update {} with id={}", unterrichtTo, unterrichtTo.getId());
        unterrichtService.updateFromTo(unterrichtTo);
    }

    void updateOnDrop(int id, String s) {
        Unterricht u = unterrichtService.get(id);
        u.setDatum(splitAndParseStrings(s));
        unterrichtService.create(u, u.getUser().getId(), u.getZahlung().getId());
    }

    public List<Unterricht> getAll() {
        return unterrichtService.getAll();
    }

    public List<UnterrichtTo> getAllTos() {
        return unterrichtService.getAllTos();
    }

    public List<String> getYears() {
        return unterrichtService.getYears();
    }

    public RequestUnterrichtTo createRequestUnterrichtTo(int id) {
        return unterrichtService.createRequestUnterrichtTo(id);
    }

    public List<MonthForStatistik> getStatistik(int year) {
        return unterrichtService.getStatistik(year);
    }
}

package art.school.web.unterricht;

import art.school.entity.Unterricht;
import art.school.service.UnterrichtService;
import art.school.to.RequestUnterrichtTo;
import art.school.to.UnterrichtTo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Slf4j
public abstract class AbstractUnterrichtController {

    @Autowired
    UnterrichtService unterrichtService;

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

    public void toggleBezahlt(int id) {
        log.info("toggle Unterricht {} Status", id);
        unterrichtService.toggleBezahlt(id);
    }

    public void update(RequestUnterrichtTo unterrichtTo) {
        log.info("update {} with id={}", unterrichtTo, unterrichtTo.getId());
        unterrichtService.updateFromTo(unterrichtTo);
    }

    void updateOnDrop(int id, String s) {
        String[] dateParts = s.replace("T", " ").split(" ");
        Unterricht u = unterrichtService.get(id);
        u.setDatum(LocalDateTime.of(LocalDate.parse(dateParts[0]), LocalTime.parse(dateParts[1])));
        unterrichtService.create(u, u.getUser().getId(), u.getZahlung().getId());
    }

    public List<Unterricht> getAll() {
        log.info("getAll Unterrichts");
        return unterrichtService.getAll();
    }

    public List<UnterrichtTo> getAllTos() {
        return unterrichtService.getAllTos();
    }

    public Set<Integer> getYears() {
        return getAll().stream().map(i -> i.getDatum().getYear()).collect(Collectors.toSet());
    }

    public List<Unterricht> getAllByYear(int year) {
        return unterrichtService.getAll()
                .stream()
                .filter(i -> i.getDatum().getYear() == year)
                .collect(Collectors.toList());
    }

    public RequestUnterrichtTo createRequestUnterrichtTo(int id) {
        return unterrichtService.createRequestUnterrichtTo(id);
    }
}

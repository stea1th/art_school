package art.school.web.unterricht;

import art.school.entity.Unterricht;
import art.school.service.UnterrichtService;
import art.school.to.RequestUnterrichtTo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static art.school.util.ValidationUtil.assureIdConsistent;
import static art.school.util.ValidationUtil.checkNew;


@Slf4j
public abstract class AbstractUnterrichtController {

    @Autowired
    UnterrichtService unterrichtService;

    public Unterricht get(int id){
        log.info("get Unterricht {}", id);
        return unterrichtService.get(id);
    }

    public Unterricht create(RequestUnterrichtTo unterrichtTo){
        Unterricht u = new Unterricht(unterrichtTo.getId(), LocalDateTime.of(LocalDate.parse(unterrichtTo.getDatum()),
                LocalTime.parse(unterrichtTo.getZeit())), unterrichtTo.isBezahlt(), unterrichtTo.getNotiz());
        log.info("create {} for Users {} and Zahlung {}", u, unterrichtTo.getKind(), unterrichtTo.getZahlung());
        checkNew(u);
        return unterrichtService.create(u, unterrichtTo.getKind(), unterrichtTo.getZahlung());
    }

    public void delete(int id){
        log.info("delete Unterricht {}", id);
        unterrichtService.delete(id);
    }

    public void toggleBezahlt(int id){
        log.info("toggle Unterricht {} Status", id);
        unterrichtService.toggleBezahlt(id);
    }

    public void update(RequestUnterrichtTo unterrichtTo){
        Unterricht u = unterrichtService.get(unterrichtTo.getId());
        u.setDatum(LocalDateTime.of(LocalDate.parse(unterrichtTo.getDatum()),
                LocalTime.parse(unterrichtTo.getZeit())));
        u.setBezahlt(unterrichtTo.isBezahlt());
        u.setNotiz(unterrichtTo.getNotiz());
        log.info("update {} with id={}", u, u.getId());
        assureIdConsistent(u, u.getId());
        unterrichtService.create(u,
                unterrichtTo.getKind()!=null? unterrichtTo.getKind() : u.getUser().getId(),
                unterrichtTo.getZahlung()!=null? unterrichtTo.getZahlung() : u.getZahlung().getId());
    }

    void updateOnDrop(int id, String s){
        String[] dateParts = s.replace("T", " ").split(" ");
        Unterricht u = unterrichtService.get(id);
        u.setDatum(LocalDateTime.of(LocalDate.parse(dateParts[0]), LocalTime.parse(dateParts[1])));
        unterrichtService.create(u, u.getUser().getId(), u.getZahlung().getId());
    }

    public List<Unterricht> getAll(){
        log.info("getAll Unterrichts");
        return unterrichtService.getAll();
    }

    public Set<Integer> getYears(){
       return getAll().stream().map(i-> i.getDatum().getYear()).collect(Collectors.toSet());
    }

    public List<Unterricht> getAllByYear(int year){
        return unterrichtService.getAll()
                .stream()
                .filter(i-> i.getDatum().getYear() == year)
                .collect(Collectors.toList());
    }
}

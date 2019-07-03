package art.school.helper;

import art.school.entity.Unterricht;
import art.school.entity.Users;
import art.school.entity.Zahlung;
import art.school.to.RequestUnterrichtTo;
import art.school.to.UnterrichtTo;
import art.school.to.ZahlungTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

import static art.school.util.DateUtil.parseStringsToLocalDateTime;

@Component
public class UnterrichtHelper {

    @Autowired
    private UserHelper userHelper;

    public UnterrichtTo createTo(Unterricht u) {
        UnterrichtTo to = new UnterrichtTo();
        Users user = u.getUser();
        LocalDateTime datum = u.getDatum();

        to.setId(u.getId());
        to.setTitle(user.getName());
        to.setStart(datum.truncatedTo(ChronoUnit.SECONDS).toString());
        to.setEnd(datum.truncatedTo(ChronoUnit.SECONDS).plusMinutes(u.getZahlung().getDauer().getLong(ChronoField.MINUTE_OF_DAY)).toString());
        to.setNotiz(u.getNotiz());
        to.setColor(!user.getAktiv() ? "grey" : u.isBezahlt() ? "green" : "red");

        return to;
    }


    public RequestUnterrichtTo createRequestTo(Unterricht u) {
        RequestUnterrichtTo to = new RequestUnterrichtTo();
        Users user = u.getUser();
        Zahlung zahlung = u.getZahlung();
        LocalDateTime datum = u.getDatum();

        to.setId(u.getId());
        to.setDatum(datum.toLocalDate().toString());
        to.setZeit(datum.toLocalTime().truncatedTo(ChronoUnit.MINUTES).toString());
        to.setKind(user.getId());
        to.setZahlung(zahlung.getId());
        to.setBezahlt(u.isBezahlt());
        to.setNotiz(u.getNotiz());
        to.setKindTo(userHelper.createTo(user));
        to.setZahlungTo(new ZahlungTo(zahlung));

        return to;
    }

    public Unterricht createUnterricht(RequestUnterrichtTo to) {
        Unterricht u = new Unterricht();
        u.setId(to.getId());
        u.setDatum(parseStringsToLocalDateTime(to.getDatum(), to.getZeit()));
        u.setBezahlt(to.isBezahlt());
        u.setNotiz(to.getNotiz());

        return u;
    }

    public List<UnterrichtTo> transformTos(List<Unterricht> list) {
        return list
                .stream()
                .map(this::createTo)
                .collect(Collectors.toList());
    }
}

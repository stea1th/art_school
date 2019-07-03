package art.school.helper;

import art.school.entity.Zahlung;
import art.school.to.ZahlungTo;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ZahlungHelper {

    public ZahlungTo createTo(Zahlung z) {
        ZahlungTo to = new ZahlungTo();

        to.setId(z.getId());
        to.setName(z.getName());
        to.setPreis(z.getPreis());
        to.setDauer(String.valueOf(z.getDauer().get(ChronoField.MINUTE_OF_DAY)));
        to.setAktiv(z.isAktiv());

        return to;
    }

    public List<ZahlungTo> transformTos(List<Zahlung> list) {
        return list.stream().map(this::createTo).collect(Collectors.toList());
    }

    public Zahlung createZahlung(ZahlungTo to) {
        Zahlung z = updateZahlung(new Zahlung(), to);
        z.setId(to.getId());
        return z;
    }

    public Zahlung updateZahlung(Zahlung z, ZahlungTo to) {
        z.setName(to.getName());
        z.setPreis(to.getPreis());
        z.setDauer(LocalTime.ofSecondOfDay(Long.valueOf(to.getDauer().split("\\.")[0]) * 60));
        z.setAktiv(to.isAktiv());

        return z;
    }
}

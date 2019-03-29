package art.school.to;

import art.school.entity.Unterricht;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestUnterrichtTo {

    private Integer id;
    private String datum;
    private String zeit;
    private Integer kind;
    private Integer zahlung;
    private boolean bezahlt;
    private String notiz;
    private UserTo kindTo;
    private ZahlungTo zahlungTo;

    public RequestUnterrichtTo(Unterricht u) {
        this(u.getId(),
                u.getDatum().toLocalDate().toString(),
                u.getDatum().toLocalTime().truncatedTo(ChronoUnit.MINUTES).toString(),
                u.getUser().getId(),
                u.getZahlung().getId(),
                u.isBezahlt(),
                u.getNotiz());
//                new UserTo(u.getUser()),
//                new ZahlungTo(u.getZahlung()));
    }

    public RequestUnterrichtTo(Integer id, String datum, String zeit, Integer kind, Integer zahlung, boolean bezahlt, String notiz) {
        this.id = id;
        this.datum = datum;
        this.zeit = zeit;
        this.kind = kind;
        this.zahlung = zahlung;
        this.bezahlt = bezahlt;
        this.notiz = notiz;
    }

    public boolean isNew() {
        return id == null;
    }

    public Unterricht createUnterricht(){
        return new Unterricht(id, LocalDateTime.of(LocalDate.parse(datum),
                LocalTime.parse(zeit)), bezahlt, notiz);
    }
}

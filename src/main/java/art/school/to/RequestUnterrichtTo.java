package art.school.to;

import art.school.entity.Unterricht;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private boolean kindIsAktiv;
    private boolean zahlungIsAktiv;

    public RequestUnterrichtTo(Unterricht u) {
        this(u.getId(),
                u.getDatum().toLocalDate().toString(),
                u.getDatum().toLocalTime().truncatedTo(ChronoUnit.MINUTES).toString(),
                u.getKind().getId(),
                u.getZahlung().getId(),
                u.isBezahlt(),
                u.getNotiz(),
                u.getKind().isAktiv(),
                u.getZahlung().isAktiv());
    }

    public boolean isNew() {
        return id == null;
    }
}

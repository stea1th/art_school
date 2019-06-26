package art.school.to;

import art.school.entity.Unterricht;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnterrichtTo {

    private Integer id;
    private String title;
    private String start;
    private String end;
    private String notiz;
    private String color;

    public UnterrichtTo(Unterricht u) {
        this(u.getId(), u.getUser().getName(),
                u.getDatum().truncatedTo(ChronoUnit.SECONDS).toString(),
                u.getDatum().truncatedTo(ChronoUnit.SECONDS).plusMinutes(u.getZahlung().getDauer().getLong(ChronoField.MINUTE_OF_DAY)).toString(), u.getNotiz(),
                !u.getUser().getAktiv() ? "grey" : u.isBezahlt() ? "green" : "red");
    }

}

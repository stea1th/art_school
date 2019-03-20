package art.school.to;

import art.school.entity.Zahlung;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.temporal.ChronoField;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ZahlungTo {

    private Integer id;
    private String name;
    private BigDecimal preis;
    private String dauer;
    private boolean aktiv;

    public ZahlungTo(Zahlung z) {
        this(z.getId(), z.getName(), z.getPreis(), String.valueOf(z.getDauer().get(ChronoField.MINUTE_OF_DAY)), z.isAktiv());
    }

    public ZahlungTo(String name, BigDecimal preis, String dauer, boolean aktiv) {
        this(null, name, preis, dauer, aktiv);
    }
}

package art.school.to;

import art.school.entity.Zahlung;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

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
        this(z.getId(), z.getName(), z.getPreis(), z.getDauer().toString(), z.isAktiv());
    }

    public ZahlungTo(String name, BigDecimal preis, String dauer, boolean aktiv) {
        this(null, name, preis, dauer, aktiv);
    }
}

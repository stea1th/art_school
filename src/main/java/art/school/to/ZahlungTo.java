package art.school.to;

import art.school.entity.Zahlung;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ZahlungTo implements Serializable {

    private int id;
    private BigDecimal preis;
    private LocalTime dauer;
    private boolean aktiv;

    public ZahlungTo(Zahlung z) {
        this(z.getId(), z.getPreis(), z.getDauer(), z.isAktiv());
    }
}

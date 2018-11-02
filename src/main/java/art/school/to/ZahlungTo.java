package art.school.to;

import art.school.entity.Zahlung;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ZahlungTo implements Serializable {

    private int id;
    private String name;
    private BigDecimal preis;
    private String dauer;
    private boolean aktiv;

    public ZahlungTo(Zahlung z) {
        this(z.getId(), z.getName(), z.getPreis(), z.getDauer().toString(), z.isAktiv());
    }
}

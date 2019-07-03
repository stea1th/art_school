package art.school.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ZahlungTo {

    private Integer id;
    private String name;
    private BigDecimal preis;
    private String dauer;
    private boolean aktiv;

    public boolean isNew(){
        return id == null;
    }

//    public ZahlungTo(Zahlung z) {
//        this(z.getId(), z.getName(), z.getPreis(), String.valueOf(z.getDauer().get(ChronoField.MINUTE_OF_DAY)), z.isAktiv());
//    }
//
//    public ZahlungTo(String name, BigDecimal preis, String dauer, boolean aktiv) {
//        this(null, name, preis, dauer, aktiv);
//    }
}

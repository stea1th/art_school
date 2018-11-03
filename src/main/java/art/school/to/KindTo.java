package art.school.to;

import art.school.entity.Kind;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.temporal.ChronoUnit;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KindTo extends AbstractTo implements Serializable {

    private int id;
    private String name;
    private String adresse;
    private boolean aktiv;
    private String registriert;

    public KindTo(Kind i){
        this(i.getId(),
                i.getName(), i.getAdresse(), i.isAktiv(),
                i.getRegistriert().truncatedTo(ChronoUnit.SECONDS)
                        .toString().replace("T", " "));
    }
}

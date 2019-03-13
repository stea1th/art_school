package art.school.to;

import art.school.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.temporal.ChronoUnit;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KindTo {

    private Integer id;
    private String name;
    private String adresse;
    private boolean aktiv;
    private String registriert;

    public KindTo(Users i){
        this(i.getId(),
                i.getName(), i.getAdresse(), i.getAktiv(),
                i.getRegistriert().truncatedTo(ChronoUnit.SECONDS)
                        .toString().replace("T", " "));
    }

    public KindTo(String name, String adresse, boolean aktiv){
        this(null, name, adresse, aktiv, null);
    }
}

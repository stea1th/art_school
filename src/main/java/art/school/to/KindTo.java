package art.school.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KindTo implements Serializable {

    private int id;
    private String name;
    private String adresse;
    private boolean aktiv;
    private LocalDateTime registriert;
}

package art.school.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private UserTo kindTo;
    private ZahlungTo zahlungTo;

    public boolean isNew() {
        return id == null;
    }
}

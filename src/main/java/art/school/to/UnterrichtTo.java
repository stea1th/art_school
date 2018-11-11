package art.school.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnterrichtTo implements Serializable {


    private int id;
    private String title;
    private LocalDateTime start;
    private LocalDateTime end;
    private String notiz;
    private String color;

}

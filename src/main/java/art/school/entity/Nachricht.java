package art.school.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@ToString
@Entity
@Table(name = "nachricht")
public class Nachricht extends AbstractBaseEntity{

    @Column(name = "text", nullable = false)
    @NotBlank
    private String text;

    @Column(name = "datum", nullable = false, columnDefinition = "timestamp default now()")
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime datum;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "u_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private Users user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "t_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private Thema thema;

    public Nachricht(Integer id, @NotBlank String text, @NotNull LocalDateTime datum) {
        super(id);
        this.text = text;
        this.datum = datum;
    }

    public Nachricht(@NotBlank String text) {
        this(null, text, LocalDateTime.now());
    }
}

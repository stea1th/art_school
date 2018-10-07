package art.school.entity;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString(exclude = {"kind", "zahlung"})
@Entity
@Table(name = "unterricht")
public class Unterricht extends AbstractBaseEntity {

    @Column(name = "datum", nullable = false, columnDefinition = "timestamp default now()")
    @NotNull
    @DateTimeFormat
    private LocalDateTime datum;

    @Column(name = "bezahlt", nullable = false, columnDefinition = "bool default true")
    private boolean bezahlt = true;

    @Column(name = "notiz")
    private String notiz;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "k_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private Kind kind;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "z_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private Zahlung zahlung;

    public Unterricht(Integer id, @NotNull LocalDateTime datum, boolean bezahlt, String notiz) {
        super(id);
        this.datum = datum;
        this.bezahlt = bezahlt;
        this.notiz = notiz;
    }

    public Unterricht(@NotNull LocalDateTime datum, String notiz) {
        this(null, datum, true, notiz);
    }

    public Unterricht(@NotNull LocalDateTime datum, boolean bezahlt, String notiz) {
        this(null, datum, bezahlt, notiz);
    }

    public Unterricht(String notiz) {
        this(null, LocalDateTime.now(), true, notiz);
    }

    public Unterricht(boolean bezahlt, String notiz) {
        this(null, LocalDateTime.now(), bezahlt, notiz);
    }

    public Unterricht(boolean bezahlt) {
        this(null, LocalDateTime.now(), bezahlt, "");
    }
}

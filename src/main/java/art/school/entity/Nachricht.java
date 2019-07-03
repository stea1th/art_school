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
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;


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
    private LocalDateTime datum = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);

    @ManyToOne
    @JoinColumn(name = "u_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private Users user;

    @ManyToOne
    @JoinColumn(name = "n_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Nachricht parent;

    @ManyToOne
    @JoinColumn(name = "t_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private Thema thema;

    @OneToMany(mappedBy = "nachricht")
    protected List<NachrichtUpdater> updaters = new ArrayList<>();

    @OneToMany(mappedBy = "parent")
    @OrderBy(value="id, datum")
    protected List<Nachricht> children = new ArrayList<>();

}

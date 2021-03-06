package art.school.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString(exclude = {"user", "zahlung"})
@Entity
@Table(name = "unterricht")
public class Unterricht extends AbstractBaseEntity {

    @Column(name = "datum", nullable = false, columnDefinition = "timestamp default now()")
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime datum;

    @Column(name = "bezahlt", nullable = false, columnDefinition = "bool default false")
    private boolean bezahlt = true;

    @Column(name = "notiz")
    private String notiz;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "u_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private Users user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "z_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private Zahlung zahlung;

}

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

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@ToString
@Entity
@Table(name = "block")
public class Block extends AbstractBaseEntity{

    @Column(name = "reason")
    private String reason;

    @Column(name = "datum")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime datum;

    @Column(name = "accepted", nullable = false, columnDefinition = "bool default false")
    private boolean accepted;

    @ManyToOne
    @JoinColumn(name = "u_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private Users user;
}

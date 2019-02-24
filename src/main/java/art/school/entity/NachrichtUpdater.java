package art.school.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "nachricht_updater")
public class NachrichtUpdater {

    @EmbeddedId
    protected NachrichtUpdaterId id;

    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Users user;

    @JoinColumn(name = "nachricht_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Nachricht nachricht;

    @Column(name = "datum", nullable = false, columnDefinition = "timestamp default now()")
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime datum;

    @Column(name = "action")
    @NotBlank
    private String action;



}

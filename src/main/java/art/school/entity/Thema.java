package art.school.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@ToString
@Entity
@Table(name = "thema")
public class Thema extends AbstractBaseEntity{

    @Column(name = "titel", nullable = false)
    @NotBlank
    private String titel;

    @Column(name = "views", nullable = false)
    @NotNull
    private int views;

    @Column(name = "aktiv")
    @NotBlank
    private Boolean aktiv;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "u_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private Users user;

    public Thema(Integer id, @NotBlank String titel, @NotNull int views, @NotNull boolean aktiv) {
        super(id);
        this.titel = titel;
        this.views = views;
        this.aktiv = aktiv;
    }

    public Thema(@NotBlank String titel) {
        this(null, titel, 0, true);
    }
}

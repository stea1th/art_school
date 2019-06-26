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
import java.util.List;

@EqualsAndHashCode(callSuper = true, exclude = {"nachrichts", "user"})
@Data
@NoArgsConstructor
@ToString(exclude = {"nachrichts", "user"})
@Entity
@Table(name = "thema")
public class Thema extends AbstractBaseEntity{

    @Column(name = "titel", nullable = false)
    @NotBlank
    private String titel;

    @Column(name = "views", nullable = false, columnDefinition = "integer default 0")
    @NotNull
    private int views;

    @Column(name = "aktiv", columnDefinition = "bool default true")
    private boolean aktiv;

    @Column(name = "gepinnt", columnDefinition = "bool default false")
    private boolean gepinnt;

    @OneToMany(mappedBy = "thema")
    @OrderBy(value = "id")
    private List<Nachricht> nachrichts;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "u_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Users user;

    public Thema(Integer id, @NotBlank String titel, @NotNull int views, @NotNull boolean aktiv, @NotNull boolean gepinnt) {
        super(id);
        this.titel = titel;
        this.views = views;
        this.aktiv = aktiv;
    }

    public Thema(@NotBlank String titel) {
        this(null, titel, 0, true, false);
    }
}

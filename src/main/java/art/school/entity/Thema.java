package art.school.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

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

    @Column(name = "views", nullable = false, columnDefinition = "integer default 0")
    @NotNull
    private int views;

    @Column(name = "aktiv", columnDefinition = "bool default true")
    private boolean aktiv;

    @Column(name = "gepinnt", columnDefinition = "bool default false")
    private boolean gepinnt;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "thema")
    @OrderBy(value = "datum")
    private List<Nachricht> nachrichts;

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

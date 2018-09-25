package art.school.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Entity
@Table(name = "kind", uniqueConstraints = {@UniqueConstraint(columnNames = {"name", "adresse"}, name = "kind_unique_name_adresse_idx")})
public class Kind extends AbstractBaseEntity{

    @Column(name = "name", nullable = false)
    @NotBlank
    @Size(max = 50)
    private String name;

    @Column(name = "adresse", nullable = false)
    @NotBlank
    @Size(min = 3, max = 50)
    private String adresse;

    @Column(name = "aktiv", nullable = false, columnDefinition = "bool default true")
    private boolean aktiv = true;

    @Column(name = "registriert", columnDefinition = "timestamp default now()")
    @NotNull
    private Date registriert = new Date();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "kind")
    protected List<Unterricht> unterrichts;
}

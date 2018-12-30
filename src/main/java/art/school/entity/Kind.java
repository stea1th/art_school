package art.school.entity;

import art.school.to.KindTo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@ToString(exclude = "unterrichts")
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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime registriert = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "kind")
    protected List<Unterricht> unterrichts;

    public Kind(Integer id, @NotBlank @Size(max = 50) String name, @NotBlank @Size(min = 3, max = 50) String adresse, boolean aktiv, @NotNull LocalDateTime registriert) {
        super(id);
        this.name = name;
        this.adresse = adresse;
        this.aktiv = aktiv;
        this.registriert = registriert;
    }

    public Kind(@NotBlank @Size(max = 50) String name, @NotBlank @Size(min = 3, max = 50) String adresse) {
        this(null, name, adresse, true, LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
    }

    public Kind(KindTo k){
        this(k.getId(), k.getName(), k.getAdresse(), k.isAktiv(), LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
    }

}

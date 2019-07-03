package art.school.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@ToString(exclude = "unterrichts")
@Entity
@Table(name = "zahlung", uniqueConstraints = {@UniqueConstraint(columnNames = {"preis", "dauer"}, name = "zahlung_unique_preis_dauer_idx")})
public class Zahlung extends AbstractBaseEntity {

    @Column(name = "name", nullable = false)
    @NotBlank
    @Size(max = 50)
    private String name;

    @Column(name = "preis", nullable = false)
    @NotNull
    private BigDecimal preis;

    @Column(name = "dauer", nullable = false)
    @NotNull
    private LocalTime dauer;

    @Column(name = "aktiv", nullable = false, columnDefinition = "bool default true")
    private boolean aktiv = true;

    @OneToMany(mappedBy = "zahlung")
    private List<Unterricht> unterrichts;

}

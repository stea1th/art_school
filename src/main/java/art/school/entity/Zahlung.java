package art.school.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Entity
@Table(name = "zahlung", uniqueConstraints = {@UniqueConstraint(columnNames = {"preis", "dauer"}, name = "zahlung_unique_preis_dauer_idx")})
public class Zahlung extends AbstractBaseEntity{

    @Column(name = "preis", nullable = false)
    @NotNull
    private BigDecimal preis;

    @Column(name = "dauer", nullable = false)
    @NotBlank
    private LocalTime dauer;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "zahlung")
    private List<Unterricht> unterrichts;

    public Zahlung(Integer id, @NotNull BigDecimal preis, @NotBlank LocalTime dauer) {
        super(id);
        this.preis = preis;
        this.dauer = dauer;
    }

    public Zahlung(@NotNull BigDecimal preis, @NotBlank LocalTime dauer) {
        this(null, preis, dauer);
    }
}

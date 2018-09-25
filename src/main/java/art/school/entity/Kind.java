package art.school.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Entity
public class Kind extends AbstractBaseEntity{



    private String name;
    private String adresse;
    private boolean aktiv;
    private List<Unterricht> unterrichtsById;



    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "adresse")
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Basic
    @Column(name = "aktiv")
    public boolean isAktiv() {
        return aktiv;
    }

    public void setAktiv(boolean aktiv) {
        this.aktiv = aktiv;
    }

    @OneToMany(mappedBy = "kindByKId")
    public List<Unterricht> getUnterrichtsById() {
        return unterrichtsById;
    }

    public void setUnterrichtsById(List<Unterricht> unterrichtsById) {
        this.unterrichtsById = unterrichtsById;
    }
}

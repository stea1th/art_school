package art.school.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Time;
import java.util.List;
import java.util.Objects;

@Entity
public class Zahlung {
    private int id;
    private BigInteger preis;
    private Time dauer;
    private List<Unterricht> unterrichtsById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "preis")
    public BigInteger getPreis() {
        return preis;
    }

    public void setPreis(BigInteger preis) {
        this.preis = preis;
    }

    @Basic
    @Column(name = "dauer")
    public Time getDauer() {
        return dauer;
    }

    public void setDauer(Time dauer) {
        this.dauer = dauer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zahlung zahlung = (Zahlung) o;
        return id == zahlung.id &&
                Objects.equals(preis, zahlung.preis) &&
                Objects.equals(dauer, zahlung.dauer);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, preis, dauer);
    }

    @OneToMany(mappedBy = "zahlungByZId")
    public List<Unterricht> getUnterrichtsById() {
        return unterrichtsById;
    }

    public void setUnterrichtsById(List<Unterricht> unterrichtsById) {
        this.unterrichtsById = unterrichtsById;
    }
}

package art.school.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Unterricht {
    private int id;
    private Timestamp datum;
    private boolean bezahlt;
    private String notiz;
    private Kind kindByKId;
    private Zahlung zahlungByZId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "datum")
    public Timestamp getDatum() {
        return datum;
    }

    public void setDatum(Timestamp datum) {
        this.datum = datum;
    }

    @Basic
    @Column(name = "bezahlt")
    public boolean isBezahlt() {
        return bezahlt;
    }

    public void setBezahlt(boolean bezahlt) {
        this.bezahlt = bezahlt;
    }

    @Basic
    @Column(name = "notiz")
    public String getNotiz() {
        return notiz;
    }

    public void setNotiz(String notiz) {
        this.notiz = notiz;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Unterricht that = (Unterricht) o;
        return id == that.id &&
                bezahlt == that.bezahlt &&
                Objects.equals(datum, that.datum) &&
                Objects.equals(notiz, that.notiz);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, datum, bezahlt, notiz);
    }

    @ManyToOne
    @JoinTable(name = "kind", catalog = "artschool", schema = "public", joinColumns = @JoinColumn(name = "id", referencedColumnName = "k_id", nullable = false))
    public Kind getKindByKId() {
        return kindByKId;
    }

    public void setKindByKId(Kind kindByKId) {
        this.kindByKId = kindByKId;
    }

    @ManyToOne
    @JoinTable(name = "kind", catalog = "artschool", schema = "public", joinColumns = @JoinColumn(name = "id", referencedColumnName = "z_id", nullable = false))
    public Zahlung getZahlungByZId() {
        return zahlungByZId;
    }

    public void setZahlungByZId(Zahlung zahlungByZId) {
        this.zahlungByZId = zahlungByZId;
    }
}

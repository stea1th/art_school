package art.school.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@ToString
@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "email", name = "kind_unique_name_adresse_idx")})
public class Users extends AbstractBaseEntity {

    @Column(name = "name", nullable = false)
    @NotBlank
    private String name;

    @Column(name = "email", nullable = false)
    @Email
    @NotBlank
    @Size(max = 100)
    private String email;

    @Column(name = "adresse", nullable = false)
    @NotBlank
    @Size(min = 3, max = 50)
    private String adresse;

    @Column(name = "admin_passwort", nullable = false)
    private String adminPasswort;

    @Column(name = "passwort", nullable = false)
    @NotBlank
    private String passwort;

    @Column(name = "registriert")
    @NotNull
    private LocalDateTime registriert = LocalDateTime.now();

    @Column(name = "aktiv")
    @NotNull
    private Boolean aktiv;

    @Enumerated(EnumType.STRING)
    @BatchSize(size = 200)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    @ElementCollection
    private Set<Role> roles;

    @OneToMany(mappedBy = "user")
    private List<Nachricht> nachrichts;

    @OneToMany(mappedBy = "user")
    protected List<Unterricht> unterrichts ;

    @OneToMany(mappedBy = "user")
    protected List<Block> blocks ;


    public Users(Integer id, @NotBlank @Size(max = 50) String name, @NotBlank @Size(min = 3, max = 50) String adresse, boolean aktiv, @NotNull LocalDateTime registriert) {
        super(id);
        this.name = name;
        this.adresse = adresse;
        this.aktiv = aktiv;
        this.registriert = registriert;
    }

    public Users(@NotBlank @Size(max = 50) String name, @NotBlank @Size(min = 3, max = 50) String adresse) {
        this(null, name, adresse, true, LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
    }

    public Users(Integer id, @NotBlank String name, @Email @NotBlank @Size(max = 100) String email,
                 @NotBlank @Size(min = 3, max = 50) String adresse, String adminPasswort,
                 @NotNull LocalDateTime registriert, @NotNull Boolean aktiv, Set<Role> roles) {
        super(id);
        this.name = name;
        this.email = email;
        this.adresse = adresse;
        this.adminPasswort = adminPasswort;
        this.registriert = registriert;
        this.aktiv = aktiv;
        this.roles = roles;
    }
}

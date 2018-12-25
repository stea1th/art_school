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
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Role> roles;

}

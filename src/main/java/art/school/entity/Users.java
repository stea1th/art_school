package art.school.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Type;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
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

    @OneToMany(mappedBy = "user")
    @OrderBy(value = "registration DESC")
    private List<UserPassword> passwords = new ArrayList<>();

//    @Column(name = "admin_passwort", nullable = false)
//    private String adminPasswort;
//
//    @Column(name = "passwort", nullable = false)
//    @NotBlank
//    private String passwort;

    @Column(name = "registriert")
    @NotNull
    private LocalDateTime registriert = LocalDateTime.now();

    @Column(name = "aktiv")
    @NotNull
    private Boolean aktiv;

    @Column(name = "image", length = 5242880)
    @Type(type = "org.hibernate.type.BinaryType")
    @Nullable
    private byte[] image;

    @Enumerated(EnumType.STRING)
    @BatchSize(size = 200)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    @ElementCollection
    private Set<Role> roles;

    @OneToMany(mappedBy = "user")
    private List<Nachricht> nachrichts;

    @OneToMany(mappedBy = "user")
    protected List<Unterricht> unterrichts;

    @OneToMany(mappedBy = "user")
    protected List<Block> blocks;

}

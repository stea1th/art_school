package art.school.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@ToString
@Entity
@Table(name = "user_password")
public class UserPassword extends AbstractBaseEntity{

    @Column(name = "admin_passwort", nullable = false)
    private String adminPasswort;

    @Column(name = "passwort", nullable = false)
    @NotBlank
    private String passwort;

    @ManyToOne
    @JoinColumn(name = "u_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private Users user;

}

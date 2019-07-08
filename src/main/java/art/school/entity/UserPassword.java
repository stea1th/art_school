package art.school.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

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

    @Column(name = "registration", nullable = false, columnDefinition = "timestamp default now()")
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime registration;

    @Column(name = "generated", nullable = false, columnDefinition = "bool default true")
    @NotNull
    private boolean generated;

    @ManyToOne
    @JoinColumn(name = "u_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private Users user;

}

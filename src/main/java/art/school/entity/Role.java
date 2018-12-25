package art.school.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
@Getter
public enum Role implements GrantedAuthority {
    ROLE_USER("Пользователь"),
    ROLE_ADMIN("Администратор");

    private String name;

    @Override
    public String getAuthority() {
        return name();
    }
}

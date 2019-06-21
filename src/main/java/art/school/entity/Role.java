package art.school.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
@Getter
public enum Role implements GrantedAuthority {
    ROLE_USER("forum.user"),
    ROLE_MODERATOR("forum.moder"),
    ROLE_ADMIN("forum.admin");

    private String name;

    @Override
    public String getAuthority() {
        return name();
    }
}

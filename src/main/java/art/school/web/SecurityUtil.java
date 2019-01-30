package art.school.web;

import art.school.AuthorizedUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Objects;

public class SecurityUtil {

    private static AuthorizedUser safeGet(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth == null)
            return null;
        Object principal = auth.getPrincipal();
        return (principal instanceof AuthorizedUser)? (AuthorizedUser)principal : null;
    }

    public static AuthorizedUser get(){
        AuthorizedUser user = safeGet();
        Objects.requireNonNull(user, "No authorized user found");
        return user;
    }

    public static int getAuthId(){
        return get().getId();
    }
}

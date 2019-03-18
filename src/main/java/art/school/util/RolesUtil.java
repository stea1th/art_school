package art.school.util;

import art.school.entity.Role;

import java.util.LinkedHashSet;
import java.util.Set;

public class RolesUtil {

    public static Set<Role> createRoles(int number){
        Set<Role> set = new LinkedHashSet<>();
        set.add(Role.ROLE_USER);
        if(number == 0) return set;
        set.add(Role.ROLE_MODERATOR);
        if(number == 1) return set;
        set.add(Role.ROLE_ADMIN);
        return set;
    }
}

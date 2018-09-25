package art.school;

import art.school.entity.AbstractBaseEntity;
import art.school.entity.Kind;

public class TestMain {
    public static void main(String[] args) {
        Kind kind = new Kind();
        AbstractBaseEntity ent = new AbstractBaseEntity(5) {
            @Override
            public Integer getId() {
                return super.getId();
            }
        };
    }
}

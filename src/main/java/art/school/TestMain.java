package art.school;

import art.school.entity.AbstractBaseEntity;
import art.school.entity.Kind;
import art.school.entity.Zahlung;

import java.math.BigDecimal;
import java.time.LocalTime;

public class TestMain {
    public static void main(String[] args) {
        Kind kind = new Kind();
        AbstractBaseEntity ent = new AbstractBaseEntity(5) {
            @Override
            public Integer getId() {
                return super.getId();
            }
        };
        Zahlung z = new Zahlung();
        Zahlung z1 = new Zahlung(1005, new BigDecimal(1.24), LocalTime.of(0, 45));

    }
}

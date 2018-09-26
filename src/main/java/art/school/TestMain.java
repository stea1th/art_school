package art.school;

import art.school.entity.Kind;
import art.school.web.KindController;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
    public static void main(String[] args) {
//        Kind kind = new Kind();
//
//        AbstractBaseEntity ent = new AbstractBaseEntity(5) {
//            @Override
//            public Integer getId() {
//                return super.getId();
//            }
//        };
//        Zahlung z = new Zahlung();
//        Zahlung z1 = new Zahlung(1005, new BigDecimal(1.24), LocalTime.of(0, 45));

        try(ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-db")){
            KindController controller = appCtx.getBean(KindController.class);
            Kind kind = controller.get(1003);

            System.out.println(kind!=null? kind.getName()+" -> "+kind.getAdresse(): "No Kind with this id!");
        }
    }
}

package art.school;

import art.school.entity.Kind;
import art.school.web.KindController;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.TimeUnit;

public class TestMain {
    public static void main(String[] args) throws InterruptedException {
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
            Kind kind = controller.get(1001);

            System.out.println(kind!=null? kind.getName()+" -> "+kind.getAdresse(): "No Kind with this id!");
            Kind kind2 = new Kind();
            kind2.setName("Vasia");
            kind2.setAdresse("Kolomojsk");
            controller.create(kind2);

            //controller.create(new Kind("Alexander", "Peuntgasse 5"));
            controller.getAll().forEach(i-> System.out.println(i.getId()+" "+i.getName()+" "+i.getAdresse()+
                    " -> "+i.getRegistriert()+" "+i.isAktiv()));

            controller.delete(1000);
            controller.setAktiv(1001, false);
            kind.setName("Vadim");
//            controller.update(kind);
            Thread.sleep(2000);
//            controller.update(new Kind(1001, "Vadim", "Puschkin-Sad"));
            //controller.update(kind);


            controller.getAll().forEach(i-> System.out.println(i.getId()+" "+i.getName()+" "+i.getAdresse()+
                    " -> "+i.getRegistriert()+" "+i.isAktiv()));
        }
    }
}

package art.school;

import art.school.entity.Kind;
import art.school.entity.Zahlung;
import art.school.web.kind.KindController;
import art.school.web.zahlung.ZahlungController;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.LocalTime;


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
            ConfigurableListableBeanFactory factory = appCtx.getBeanFactory();
            ZahlungController zahlungController = factory.getBean(ZahlungController.class);
//            ZahlungController zahlungController = appCtx.ge


//            System.out.println(kind!=null? kind.getName()+" -> "+kind.getAdresse(): "No Kind with this id!");
//            Kind kind2 = new Kind();
//            kind2.setName("Vasia");
//            kind2.setAdresse("Kolomojsk");
//            controller.create(kind2);

            controller.create(new Kind("Alexander", "Peuntgasse 5"));
            controller.getAll().forEach(i-> System.out.println(i.getId()+" "+i.getName()+" "+i.getAdresse()+
                    " -> "+i.getRegistriert()+" "+i.isAktiv()));

            controller.delete(1000);
            controller.toggleAktiv(1001);
            controller.toggleAktiv(1010);
            Kind kind = controller.get(1001);

            kind.setName("Vadim");
            controller.update(kind, 1001);
//            Thread.sleep(2000);
//            controller.update(new Kind(1001, "Vadim", "Puschkin-Sad"));
//            controller.update(kind);


            controller.getAll().forEach(i-> System.out.println(i.getId()+" "+i.getName()+" "+i.getAdresse()+
                    " -> "+i.getRegistriert()+" "+i.isAktiv()));

            Zahlung z = zahlungController.get(1003);
            z.setDauer(LocalTime.ofSecondOfDay(61*60));
            zahlungController.update(z, z.getId());

            Zahlung z2 = new Zahlung(BigDecimal.valueOf(99.125434).setScale(2, RoundingMode.HALF_UP), LocalTime.of(2, 35));
            zahlungController.create(z2);

            zahlungController.getAll().forEach(i-> System.out.println(i.getId()+" "+i.getPreis()+" -> "+i.getDauer()));
            System.out.println("Summe => "+zahlungController.getAll().stream().mapToDouble(i-> i.getPreis().doubleValue()).sum());
        }
    }
}

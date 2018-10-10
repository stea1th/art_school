package art.school;

import art.school.entity.Kind;
import art.school.entity.Unterricht;
import art.school.entity.Zahlung;
import art.school.web.kind.KindController;
import art.school.web.unterricht.UnterrichtController;
import art.school.web.zahlung.ZahlungController;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalTime;
import java.util.List;


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

        try(ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-db.xml")){
            KindController controller = appCtx.getBean(KindController.class);
            ConfigurableListableBeanFactory factory = appCtx.getBeanFactory();
            ZahlungController zahlungController = factory.getBean(ZahlungController.class);
            UnterrichtController unterrichtController = factory.getBean(UnterrichtController.class);
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
            kind.getUnterrichts().forEach(i-> System.out.println(i.getNotiz()));

            unterrichtController.create(new Unterricht(true, "Kogda zhe eto vse zakonchitsia??"), 1001, 1011);
            unterrichtController.create(new Unterricht(false), 1001, 1004);
            unterrichtController.getAll().forEach(i-> System.out.println(i.getId()+" "+i.getDatum()+" "
                    +i.isBezahlt()+" "+i.getNotiz()+" "+i.getKind().getName()));
            unterrichtController.delete(1006);

//            unterrichtController.toggleBezahlt(1013);
            System.out.println(unterrichtController.get(1013).isBezahlt());
            List<Unterricht> list = unterrichtController.getAll();
            list.forEach(i-> System.out.println(i.getId()+" "+i.getDatum().toLocalDate()+" -> "
                    +i.isBezahlt()+" "+i.getNotiz()+" "+i.getKind().getName()));


            System.out.println("Всего за "+list.size()+" урока я заработала "
                    +list.stream().filter(Unterricht::isBezahlt).mapToDouble(i->i.getZahlung().getPreis().doubleValue()).sum()+" евро");

//            unterrichtController.get(1100);
            System.out.println(unterrichtController.create(new Unterricht("Error"), 1001, 1004).toString());
            System.out.println(controller.get(1001));
            System.out.println(zahlungController.get(1003));

        }
    }
}

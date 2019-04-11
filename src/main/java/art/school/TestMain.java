package art.school;

import art.school.to.UnterrichtTo;
import art.school.web.unterricht.UnterrichtRestController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;


public class TestMain {
    public static void main(String[] args) throws JsonProcessingException {

        try(ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-db.xml")) {
            UnterrichtRestController controller = appCtx.getBean(UnterrichtRestController.class);
            List<UnterrichtTo> list = new ArrayList<>();

//            controller.getAll().forEach(i-> list.add(new UnterrichtTo(i.getDatum()
//                    .truncatedTo(ChronoUnit.SECONDS)
//                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
//                    i.getKind().getName(),
//                    i.getNotiz())));

            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String json = ow.writeValueAsString(list);

            System.out.println(json);

//            controller.getAll().forEach(i-> System.out.println(i.getDatum()
//                    .truncatedTo(ChronoUnit.SECONDS)
//                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))+" -> "+i.getKind().getName()+" -> "+i.getNotiz()));

        }
    }
}

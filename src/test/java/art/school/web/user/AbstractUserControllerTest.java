package art.school.web.user;

import art.school.entity.Users;
import art.school.service.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.PostConstruct;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

@ContextConfiguration(locations = {"classpath:spring-test.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class AbstractUserControllerTest {

    @Autowired
    private UserService service;

    @PostConstruct
    private void postConstruct(){

    }

    @Before
    public void setUp() throws Exception {
        service.create(new Users(7, "Vadim", "Einsteinring" , true, LocalDateTime.now()));

    }

    @After
    public void tearDown() throws Exception {
        service.delete(7);
    }

    @Test
    public void get() {
//        System.out.println(service.get(7));

    }

}
package art.school.web.user;

import art.school.entity.Users;
import art.school.service.UserService;
import art.school.to.UserTo;
import net.bytebuddy.asm.Advice;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.annotation.PostConstruct;
import javax.persistence.PersistenceContext;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration(locations = {"classpath:spring-test.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
public class KindRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

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
    }

    @Test
    public void all() throws Exception {
//        service.create(new Users(7, "Vadim", "Einsteinring" , true, LocalDateTime.now()));
        mockMvc.perform(get("/api/kind")).andExpect(status().isOk());

    }
}
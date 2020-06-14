import contacts.Application;
import contacts.Contact;
import contacts.ContactRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
//@AutoConfigureMockMvc
public class ApplicationTest {

    @Mock
    private ContactRepository contactRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;

    MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        Contact contact = createFakeContact();
        List<Contact> list = new ArrayList<>();
        list.add(contact);
        Mockito.when(contactRepository.findAll())
                .thenReturn(list);
    }

    @Test
    public void contextLoads() throws Exception {
        String uri = "/";
        mockMvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON))
//                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void sayHello() throws Exception {
        String uri = "/hello";
        mockMvc.perform(MockMvcRequestBuilders.get(uri))
//                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("hello"));
    }

    @Test
    public void getJSON() throws Exception {
        String uri = "/json";
        mockMvc.perform(MockMvcRequestBuilders.get(uri))
//                .andDo(print())
                .andExpect(status().isOk())
//                .andExpect(content().string("{\"response\":\"json string\"}"));
                .andExpect(content().json("{\"response\":\"json string\"}"))
                .andExpect(jsonPath("$.response", is("json string")));
    }

    private Contact createFakeContact() {
        Contact contact = new Contact();
        contact.setId(1L);
        contact.setFirstName("firstName");
        contact.setLastName("lastName");
        contact.setPhoneNumber("number");
        contact.setEmailAddress("address");
        return contact;
    }
}

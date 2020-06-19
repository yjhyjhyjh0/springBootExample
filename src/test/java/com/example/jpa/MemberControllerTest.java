package com.example.jpa;

//import com.example.Application;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.jpa.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
@DataJpaTest
//@SpringBootTest(classes = Application.class)
public class MemberControllerTest {

//    @Autowired
//    MemberRepository repository;

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private MemberRepository employeeRepository;

    @Test
    public void testRepository() {
        MemberAccountJPA m1 = new MemberAccountJPA();
        m1.setAddress("address");
        m1.setCellphone("phone");
        m1.setEmail("mail");
        m1.setPassword("pass");

        entityManager.persist(m1);
        entityManager.flush();

        MemberAccountJPA result = employeeRepository.findByEmail(m1.getEmail());
        Assert.assertNotNull(result.getId());
        Assert.assertEquals(result.getAddress(), "address");
    }
}

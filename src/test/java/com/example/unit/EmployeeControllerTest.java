package com.example.unit;

import com.example.unit.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * https://howtodoinjava.com/spring-boot2/testing/rest-controller-unit-test-example/
 * While writing junit test for a rest controller method, we shall keep in mind that:
 *
 * A com.example.unit test is supposed to test only a certain part of code (i.e. code written in controller class), so we shall mock all the dependencies injected and used in controller class.
 * If the test utilizes other dependencies (e.g. database/network) then it is integration testing and not com.example.unit testing.
 * We should not use any webserver otherwise it will make the com.example.unit testing slow.
 * Each com.example.unit test should be independent of other tests.
 * By definition, com.example.unit tests should be fast.
 */
@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest {
    @InjectMocks
    EmployeeController employeeController;

    @Mock
    EmployDAO employDAO;

    @Test
    public void testAddEmployee() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        when(employDAO.addEmployee(any(Employee.class))).thenReturn(true);

        Employee employee = new Employee(1, "Lokesh", "Gupta", "howtodoinjava@gmail.com");
        ResponseEntity<Object> responseEntity = employeeController.addEmployee(employee);

        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
        assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("/1");

        System.out.println("hello");
    }

    @Test
    public void testFindAll() {
        // given
        Employee employee1 = new Employee(1, "Lokesh", "Gupta", "howtodoinjava@gmail.com");
        Employee employee2 = new Employee(2, "Alex", "Gussin", "example@gmail.com");
        Employees employees = new Employees();
        employees.setEmployeeList(Arrays.asList(employee1, employee2));

        when(employDAO.getAllEmployees()).thenReturn(employees);

        // when
        Employees result = employeeController.getEmployees();

        // then
        assertThat(result.getEmployeeList().size()).isEqualTo(2);

        assertThat(result.getEmployeeList().get(0).getFirstName())
                .isEqualTo(employee1.getFirstName());

        assertThat(result.getEmployeeList().get(1).getFirstName())
                .isEqualTo(employee2.getFirstName());

        System.out.println("hello2");

    }
}

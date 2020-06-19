
# SpringBootExample
Example of runnable spring boot application based on Spring in Action 4

## Usage
Launch main in com.example.Application.class and check localhost:8085  

## Other Libraries
Hamcrest

## Resources
R1-Unit Test guide
https://howtodoinjava.com/spring-boot2/testing/spring-boot-mockmvc-example/
https://www.baeldung.com/spring-boot-testing
https://ithelp.ithome.com.tw/articles/10196471
https://spring.io/guides/gs/testing-web/
https://howtodoinjava.com/spring-boot2/testing/springboottest-annotation/

## FAQ
Q1-spring boot java.net.BindException: Address already in use  
A1-Change your application server port, for that create a file named application.properties in resource folder and add property  
server.port = 8085

Q2-Unable to find a @SpringBootConfiguration  
A2-Need to specify the application class Ex:@SpringBootTest(classes = com.example.Application.class)
https://stackoverflow.com/questions/39084491/unable-to-find-a-springbootconfiguration-when-doing-a-jpatest

Q3-Error processing condition on org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration$ThymeleafWebMvcConfiguration.resourceUrlEncodingFilter  
A3-This is caused by non-matching Spring Boot dependencies.  
Use spring-boot-starter-thymeleaf instead of org.thymeleaf

Q4-MockRepository encounter MissingMethodInvocationException  
Add @Mock to MockRespoitory  
@Mock creates a mock. 
@InjectMocks creates an instance of the class and injects the mocks that are created with the @Mock (or @Spy) annotations into this instance.  
Note that you must use @RunWith(MockitoJUnitRunner.class) or Mockito.initMocks(this) to initialize these mocks and inject them.
https://stackoverflow.com/questions/16467685/difference-between-mock-and-injectmocks    
    
Q5-What is @AutoConfigureWebMvc and @AutoConfigureMockMvc  
@AutoConfigureWebMvc  
Use this if you need to configure the web layer for testing but don't need to use MockMvc  
It enables all auto-configuration related to the web layer and ONLY the web layer. This is a subset of overall auto-configuration.

@AutoConfigureMockMvc  
Use this when you just want to configure MockMvc  
Enables all auto-configuration related to MockMvc and ONLY MockMvc. Again, this is a subset of overall auto-configuration.  

@WebMvcTest  
Includes both the @AutoConfigureWebMvc and the @AutoConfigureMockMvc, among other functionality.  
https://stackoverflow.com/questions/46343782/whats-the-difference-between-autoconfigurewebmvc-and-autoconfiguremockmvc

Q6-Difference between @RunWith(SpringRunner.class) and @RunWith(SpringJUnit4ClassRunner.class)
There is no difference, from the javadoc:  
SpringRunner is an alias for the SpringJUnit4ClassRunner.  
https://stackoverflow.com/questions/47446529/what-is-the-difference-between-springjunit4classrunner-and-springrunner 

Q7-How to write com.example.unit test on controller?  
https://howtodoinjava.com/spring-boot2/testing/rest-controller-com.example.unit-test-example/  
While writing junit test for a rest controller method, we shall keep in mind that:  
A com.example.unit test is supposed to test only a certain part of code (i.e. code written in controller class), so we shall mock all the dependencies injected and used in controller class.  
If the test utilizes other dependencies (e.g. database/network) then it is integration testing and not com.example.unit testing.  
We should not use any webserver otherwise it will make the com.example.unit testing slow.  
Each com.example.unit test should be independent of other tests.  
By definition, com.example.unit tests should be fast.  

Q8-detached entity passed to persist exception.
One reason for this case is setting a auto generate value during unit test.

Q9-JPA example  
https://github.com/hellokoding/hellokoding-courses/tree/master/springboot-examples/springboot-restapi-testing-all-layers/src/test/java/com/hellokoding/springboot/restful/product
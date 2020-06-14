
# SpringBootExample
Example of runnable spring boot application based on Spring in Action 4

## Usage
Launch main in Application.class and check localhost:8085  

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
A2-Need to specify the application class Ex:@SpringBootTest(classes = Application.class)

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

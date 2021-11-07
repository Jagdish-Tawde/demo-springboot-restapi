# demo-springboot-restapi
Project is created for more understanding of Rest API. Project doesn't have UI for now. 
used H2 database in a project.
handle requests such as 
1) GET Request. --> get data from database.
2) POST Request. --> add data to database.
3) DELETE Request. --> delete something from database.
4) PUT Request. --> update something in database

Some of new anotations

@Configuration :- Spring Configuration annotation indicates that the class has @Bean definition methods. 
So Spring container can process the class and generate Spring Beans to be used in the 

@Bean :- used to explicitly declare a bean creation

@Transactional :- 

@Transient -: which means the field marked with @Transient is ignored by mapping framework and the field not mapped to any database column


Added a little bit of UNIT testing with Assertj

@ExtendWith(MockitoExtension.class) :- The @ExtendWith annotation is used to load a JUnit 5 extension. JUnit defines an extension API, 
which allows a third-party vendor like Mockito to hook into the lifecycle of running test classes and add additional functionality.

@DataJpaTest :- used to test JPA repositories.

@AfterEach :- is used to signal that the annotated method should be executed after each @Test method in the current class.

@BeforeEach :- is used to signal that the annotated method should be executed before each @Test method in the current class.

@Disabled :- Test will be ignored.

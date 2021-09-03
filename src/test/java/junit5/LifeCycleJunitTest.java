package junit5;

import common.Calculator;
import common.Customer;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Author : mahdi ,  Date : 9/2/2021
 */
@Tag("LifeCycleJunitTest")
@Tag("dao")
public class LifeCycleJunitTest {

    //static fileds
    private static Calculator calculator;
    private static Customer customer;

    //static method
    //run this code once before all test
    //this is static (default)
    //it can be nonstatic if @TestInstance(TestInstance.Lifecycle.PER_CLASS) on class
    @BeforeAll
    static void beforeAllTest() {
        calculator = new Calculator();
        customer = new Customer("mahdi");
        System.out.println("@BeforeAll : set config for all Tests ...");
    }

    //static method
    @AfterAll
    public static void afterAllTest() {
        System.out.println("@AfterAll : Release resources like db connection, close files and ...");
    }


    @BeforeEach
    void beforeCallAnyTest() {
        System.out.println("@BeforeEach : this is called before run any test");

    }

    @AfterEach
    public void afterEachTest() {
        System.out.println("@AfterEach : this is called after any test");
    }

    @Test
    @DisplayName("test sum :)") //show this name for test, default display name is Method name
    public void testSum(){
        assertEquals(2, calculator.sum(1,1));
    }

    @Test
    public void testCustomer(){
        assertEquals("mahdi", customer.getName());
    }
}

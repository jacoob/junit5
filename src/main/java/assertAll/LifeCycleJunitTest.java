package assertAll;

import common.Calculator;
import common.Customer;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Author : mahdi ,  Date : 9/2/2021
 */
public class LifeCycleJunitTest {

    //static fileds
    private static Calculator calculator;
    private static Customer customer;

    //static method
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
    public void testSum(){
        assertEquals(2, calculator.sum(1,1));
    }

    @Test
    public void testCustomer(){
        assertEquals("mahdi", customer.getName());
    }
}

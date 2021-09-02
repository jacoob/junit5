package assertAll;

import common.Calculator;
import common.Customer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Author : mahdi ,  Date : 9/2/2021
 */
public class NestedTestsTest {
    private static String name = "mahdi";
    private static int num1 = 1;
    private static int num2 = 1;
    private static Calculator calculator = new Calculator();
    private static Customer customer = new Customer(name);

    //inner class can be public or package private
    //inner class have access to private members (filed, method)
    //tightly coupled with the nested test
    //The source code file has nested class.
    @Nested
    class NestedTest {

        @Test
        public void testCalculator() {
            assertAll(
                    () -> assertEquals(2, calculator.sum(num1, num2)),
                    () -> assertEquals(name, customer.getName())
            );
        }
    }
}

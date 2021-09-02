package junit5;

import common.Calculator;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Author : mahdi ,  Date : 9/2/2021
 */

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LifeCycleJunitTestNonStatic {
    Calculator calculator;

    //run this code once before all test
    //this is static (default)
    //it can be nonstatic if @TestInstance(TestInstance.Lifecycle.PER_CLASS) on class
    //access modifier can be package private or public
    @BeforeAll
    void initTest() {
        calculator = new Calculator();
    }

    //access modifier can be package private or public
    //return type must be void
    @Test
    @DisplayName("test sum :)") //show this name for test, default display name is Method name
    void testSum() {
        assertEquals(2, calculator.sum(1, 1));
    }

    @Test
    void testAssertAll(){
        Assertions.assertAll(
                ()->assertEquals(calculator.sum(1,2),3),
                ()->assertEquals(calculator.divided(1,1),1),
                ()->assertEquals(calculator.multiple(1,1),1),
                ()->assertEquals(calculator.subtraction(1,1),0)
        );
    }
}

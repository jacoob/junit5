package assertAll;


import common.Calculator;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Author : mahdi ,  Date : 9/2/2021
 */



public class AssertAllTeat {

    static Calculator calculator;


    @BeforeAll
     static void initTest() {
        calculator = new Calculator();
    }

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

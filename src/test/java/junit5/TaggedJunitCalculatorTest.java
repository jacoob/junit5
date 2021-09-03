package junit5;


import common.Calculator;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Author : mahdi ,  Date : 9/2/2021
 */


@Tag("dao")
@Tag("CalculatorTest")
public class TaggedJunitCalculatorTest {

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

    //the assertAll method receives as a parameter the message to be displayed if one of the supplied executables throws an exception
    //We can use lambda or method references to verify
    //The advantage of using lambda expressions as arguments for assertion methods is that all of them are lazily created, resulting in improved performance
    @Test
    void testAssertAll(){
        Assertions.assertAll("if any rest of asserts throws exception, this msg is showed in log console",
                ()->assertEquals(calculator.sum(1,2),3),
                ()->assertEquals(calculator.divided(1,1),1),
                ()->assertEquals(calculator.multiple(1,1),1),
                ()->assertEquals(calculator.subtraction(1,1),0)
                );
    }

}

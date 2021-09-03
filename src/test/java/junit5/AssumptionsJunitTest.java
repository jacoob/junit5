package junit5;

import common.TF;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.*;

/**
 * Author : mahdi ,  Date : 9/3/2021
 */

//Sometimes tests fail due to an external environment configuration or a date or time zone issue that we cannot control. We can prevent our tests from being executed under inappropriate conditions.
//Assumptions verify the fulfillment of preconditions that are essential for running the tests
public class AssumptionsJunitTest {
    @BeforeAll
    public static void init(){
        System.setProperty("t1","t1");
    }
    //assumption is t1 =t1  that is true, then continue the rest of test
    @Test
    public void assumeTrue1(){
        assumeTrue(System.getProperty("t1").equals("t1"));
        System.out.println("assumeTrue1 is continue , and System.getProperty() is : " + System.getProperty("t1"));
    }

    //assumption is t1 =t2 that is not true, then doesn't continue the rest of test and show msg in console
    @Test
    public void assumeTrue2(){
        assumeTrue(System.getProperty("t1").equals("t2"),"assumeTrue2 is ended ");
        System.out.println("assumeTrue2 is continue , and System.getProperty() is : " + System.getProperty("t1"));
    }
    //assumption is t1 !=t2 that is true, then continue the rest of test
    @Test
    public void assumeTrue3(){
        assumeFalse(System.getProperty("t1").equals("t2"));
        System.out.println("assumeTrue3 is continue");
    }

    //assumption is t1 != t1 that is not true, then doesn't continue the rest of test and show msg in console
    @Test
    public void assumeTrue4(){
        assumeFalse(System.getProperty("t1").equals("t1"),"assumeTrue4 is ended ");
        System.out.println("assumeTrue4 is continue");
    }

}

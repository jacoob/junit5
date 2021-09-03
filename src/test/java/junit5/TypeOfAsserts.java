package junit5;

import common.Calculator;
import common.Customer;
import common.MyException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Author : mahdi ,  Date : 9/3/2021
 */
public class TypeOfAsserts {

    private Calculator calculator = new Calculator();
    private Customer customer = new Customer("mahdi");

    //assertTimeout waits until the executable finishes
    //The failure message looks something like this: execution exceeded timeout of 1 ms by 14 ms.
    @Test
    @DisplayName("A job is executed within a timeout")
    public void testTimeout1() {
        assertTimeout(Duration.ofMillis(1),
                () -> calculator.sumDelay(1, 1));
    }

    @Test
    @DisplayName("A job is executed within a timeout")
    public void testTimeout2() {
        assertTimeout(Duration.ofMillis(5),
                () -> calculator.sum(1, 1));
    }

    //assertTimeoutPreemptively stops the executable when the time has expired.
    //The failure message looks like this: execution timed out after 500 ms
    @Test
    @DisplayName("A job is executed within a timeout")
    public void testTimeout3() {
        assertTimeoutPreemptively(Duration.ofMillis(1),
                () -> calculator.sumDelay(1, 1));
    }

    @Test
    @DisplayName("A job is executed within a timeout")
    public void testTimeout4() {
        assertTimeoutPreemptively(Duration.ofMillis(5),
                () -> calculator.sum(1, 1));
    }

    //get a Throwable reference with call assertThrows and check its message.
    @Test
    @DisplayName("An exception is caught")
    void testCatchException6() {
        Throwable throwable = assertThrows(MyException.class,
                () -> customer.getException());
        assertEquals("No jobs on the execution list!",
                throwable.getMessage());
    }


    //We verify that the systemUnderTest object’s (customer) call of the method throws a MyException
    @Test
    @DisplayName("An exception is expected")
    void testExpectedException5() {
        assertThrows(MyException.class, customer::getException);
    }
}


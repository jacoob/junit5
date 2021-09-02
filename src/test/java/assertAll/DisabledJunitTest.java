package assertAll;

import common.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Author : mahdi ,  Date : 9/2/2021
 */

//this test is ignored by maven or other tools because this test class is disabled by @Disabled!
@Disabled("feature is still under construction!")
public class DisabledJunitTest {
    @Test
    public void testCustomer() {
        assertEquals(2, new Calculator().sum(1, 1));
    }
}

package junit5;

import common.Customer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;



/**
 * Author : mahdi ,  Date : 9/2/2021
 */


//tag over class and over method
//use tags to filter test discovery and execution.(in pom, <groups> and <excludedGroups> in maven-surefire-plugin

@Tag("dao")
@Tag("CustomerTest")
public class TaggedJunitCustomerTest {
    private static Customer customer;

    @BeforeAll
    public static void initTest() {
        customer = new Customer("mahdi");
    }

    @Test
    @DisplayName("Customer Name Test")
    void customerTest() {
        assertEquals("mahdi", customer.getName());
    }
}

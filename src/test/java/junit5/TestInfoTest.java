package junit5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Author : mahdi ,  Date : 9/3/2021
 */

//test constructors and methods to have parameters, but they need to be resolved through dependency injection.
//The ParameterResolver interface dynamically resolves parameters at runtime.
//A parameter of a constructor or method must be resolved at runtime by a registered ParameterResolver.
//JUnit 5 now has three built-in resolvers.
//You must explicitly enable other parameter resolvers by registering appropriate extensions via @ExtendWith.
//TestInfoParameterResolver has a inner class (private static class DefaultTestInfo implements TestInfo)

@DisplayName("TestInfoTest11")  //default dispaly name is class name.
public class TestInfoTest {

    //If a constructor or method parameter is of type TestInfo, TestInfoParameterResolver supplies an instance of this type.
    //TestInfo is a class whose objects are used to inject information about the currently executed test
    // or container into the @Test, @BeforeEach, @AfterEach, @BeforeAll, and @AfterAll methods.
    public TestInfoTest(TestInfo testInfo) {
        assertEquals("TestInfoTest11", testInfo.getDisplayName());
    }

    //Then TestInfo gets information about the current test: the display name, test class or method, and associated tags.
    @BeforeEach
    public void setup(TestInfo testInfo) {
        String displayName = testInfo.getDisplayName();
        assertTrue(
                displayName.equals("display name of the method") ||
                        displayName.equals("testGetNameOfTheMethod(TestInfo)")

        );
    }

    @Test
    void testGetNameOfTheMethod(TestInfo testInfo) {
        assertEquals("testGetNameOfTheMethod(TestInfo)",
                testInfo.getDisplayName());
    }

    @Test
    @DisplayName("display name of the method")
    void testGetNameOfTheMethodWithDisplayNameAnnotation(TestInfo testInfo) {
        assertEquals("display name of the method",
                testInfo.getDisplayName());
    }
}

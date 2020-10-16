package Testing.testingPractice;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UtilitiesTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void everyNthChar() {
    }

    @Test
    public void removePairs() {
        Utilities utilities = new Utilities();
        assertEquals("ABCDEF",utilities.removePairs("AABCDDEFF"));
    }

    @Test
    public void converter() {
    }

    @Test
    public void nullIfOddLength() {
    }
}
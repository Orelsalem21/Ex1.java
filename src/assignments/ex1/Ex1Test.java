package assignments.ex1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Ex1.java. Validates all the implemented methods.
 */
class Ex1Test {

    /**
     * Tests the isNumber method with valid inputs.
     */
    @Test
    void testIsNumber_ValidCases() {
        String[] validNumbers = {"101b2", "A1b16", "123b10", "EFbG", "0b2", "123b6"};
        for (String number : validNumbers) {
            assertTrue(Ex1.isNumber(number));
        }
    }

    /**
     * Tests the isNumber method with invalid inputs.
     */
    @Test
    void testIsNumber_InvalidCases() {
        String[] invalidNumbers = {"", "12b", "b2", "12b20", "12b1", "G1b16", "-123b10"};
        for (String number : invalidNumbers) {
            assertFalse(Ex1.isNumber(number));
        }
    }

    /**
     * Tests the number2Int method with valid formatted strings.
     */
    @Test
    void testNumber2Int_ValidCases() {
        Object[][] validCases = {
                {"101b2", 5},
                {"A1b16", 161},
                {"123b10", 123},
                {"EFbG", 239},
                {"10011b2", 19}
        };
        for (Object[] testCase : validCases) {
            String input = (String) testCase[0];
            int expected = (int) testCase[1];
            assertEquals(expected, Ex1.number2Int(input));
        }
    }

    /**
     * Tests the number2Int method with invalid formatted strings.
     */
    @Test
    void testNumber2Int_InvalidCases() {
        String[] invalidCases = {"12b20", "12b", "b2", "-123b10"};
        for (String input : invalidCases) {
            assertEquals(-1, Ex1.number2Int(input));
        }
    }

    /**
     * Tests the int2Number method with valid inputs.
     */
    @Test
    void testInt2Number_ValidCases() {
        Object[][] validCases = {
                {5, 2, "101"},
                {161, 16, "A1"},
                {123, 10, "123"},
                {228, 16, "E4"},
                {6, 2, "110"}
        };
        for (Object[] testCase : validCases) {
            int num = (int) testCase[0];
            int base = (int) testCase[1];
            String expected = (String) testCase[2];
            assertEquals(expected, Ex1.int2Number(num, base));
        }
    }

    /**
     * Tests the int2Number method with invalid base.
     */
    @Test
    void testInt2Number_InvalidCases() {
        assertEquals("", Ex1.int2Number(5, 1)); // Base less than 2
        assertEquals("", Ex1.int2Number(5, 17)); // Base greater than 16
    }

    /**
     * Tests the maxIndex method to find the index of the largest number.
     */
    @Test
    void testMaxIndex() {
        String[][] cases = {
                {"101b2", "A1b16", "123b10", "EFbG"},
                {"101b2", "110b2", "123b10"}
        };
        int[] expectedIndices = {3, 2};
        for (int i = 0; i < cases.length; i++) {
            assertEquals(expectedIndices[i], Ex1.maxIndex(cases[i]));
        }
    }

    /**
     * Tests handling of invalid formats in operations.
     */
    @Test
    void testInvalidFormatHandling() {
        String invalid = "1234b17";
        assertFalse(Ex1.isNumber(invalid));
        assertEquals(-1, Ex1.number2Int(invalid));
        assertEquals("", Ex1.int2Number(1234, 17));
    }

    /**
     * Tests extreme values and edge cases.
     */
    @Test
    void testEdgeCases() {
        assertEquals(-1, Ex1.number2Int(null)); // Null input
        assertEquals(-1, Ex1.number2Int("")); // Empty string
    }

    /**
     * Tests sum and product operations with larger numbers.
     */
    @Test
    void testLargeNumbers() {
        int base = 10;
        long sum = (long) Integer.MAX_VALUE + Integer.MAX_VALUE;
        assertEquals("4294967294", Ex1.int2Number((int) sum, base));
    }
}

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
        assertTrue(Ex1.isNumber("101b2")); // Binary
        assertTrue(Ex1.isNumber("A1b16")); // Hexadecimal
        assertTrue(Ex1.isNumber("123b10")); // Decimal
        assertTrue(Ex1.isNumber("EFbG")); // Base G
    }

    /**
     * Tests the isNumber method with invalid inputs.
     */
    @Test
    void testIsNumber_InvalidCases() {
        assertFalse(Ex1.isNumber("")); // Empty string
        assertFalse(Ex1.isNumber("12b")); // Missing base
        assertFalse(Ex1.isNumber("b2")); // Missing number
        assertFalse(Ex1.isNumber("12b20")); // Invalid base
    }

    /**
     * Tests the number2Int method with valid formatted strings.
     */
    @Test
    void testNumber2Int_ValidCases() {
        assertEquals(5, Ex1.number2Int("101b2")); // Binary to decimal
        assertEquals(161, Ex1.number2Int("A1b16")); // Hexadecimal to decimal
        assertEquals(123, Ex1.number2Int("123b10")); // Decimal to decimal
        assertEquals(239, Ex1.number2Int("EFbG")); // Base G to decimal
    }

    /**
     * Tests the number2Int method with invalid formatted strings.
     */
    @Test
    void testNumber2Int_InvalidCases() {
        assertEquals(-1, Ex1.number2Int("12b20")); // Invalid base
        assertEquals(-1, Ex1.number2Int("12b")); // Missing base
        assertEquals(-1, Ex1.number2Int("b2")); // Missing number
    }

    /**
     * Tests the int2Number method with valid inputs.
     */
    @Test
    void testInt2Number_ValidCases() {
        assertEquals("101", Ex1.int2Number(5, 2)); // Decimal to binary
        assertEquals("A1", Ex1.int2Number(161, 16)); // Decimal to hexadecimal
        assertEquals("123", Ex1.int2Number(123, 10)); // Decimal to decimal
    }

    /**
     * Tests the maxIndex method to find the index of the largest number.
     */
    @Test
    void testMaxIndex() {
        String[] numbers = {"101b2", "A1b16", "123b10", "EFbG"};
        assertEquals(3, Ex1.maxIndex(numbers)); // Largest number index
    }

    /**
     * Validates a bug fix scenario for specific inputs and operations.
     */
    @Test
    void testBugCase() {
        String num1 = "EFbG";
        String num2 = "101b2";
        int base = 8;
        String expectedSum = "364";
        String expectedProduct = "2253";

        assertEquals(239, Ex1.number2Int(num1)); // Convert EFbG to decimal
        assertEquals(5, Ex1.number2Int(num2)); // Convert 101b2 to decimal
        assertEquals(expectedSum, Ex1.int2Number(239 + 5, base)); // Sum in base 8
        assertEquals(expectedProduct, Ex1.int2Number(239 * 5, base)); // Product in base 8
    }
}

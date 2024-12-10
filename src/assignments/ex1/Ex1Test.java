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
        assertTrue(Ex1.isNumber("0b2")); // Binary with leading zero
        assertTrue(Ex1.isNumber("123b6")); // Base 6
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
        assertFalse(Ex1.isNumber("12b1")); // Base less than 2
        assertFalse(Ex1.isNumber("G1b16")); // Invalid character for base 16
        assertFalse(Ex1.isNumber("-123b10")); // Negative numbers
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
        assertEquals(19, Ex1.number2Int("10011b2")); // Complex binary
    }

    /**
     * Tests the number2Int method with invalid formatted strings.
     */
    @Test
    void testNumber2Int_InvalidCases() {
        assertEquals(-1, Ex1.number2Int("12b20")); // Invalid base
        assertEquals(-1, Ex1.number2Int("12b")); // Missing base
        assertEquals(-1, Ex1.number2Int("b2")); // Missing number
        assertEquals(-1, Ex1.number2Int("-123b10")); // Negative numbers
    }

    /**
     * Tests the int2Number method with valid inputs.
     */
    @Test
    void testInt2Number_ValidCases() {
        assertEquals("101", Ex1.int2Number(5, 2)); // Decimal to binary
        assertEquals("A1", Ex1.int2Number(161, 16)); // Decimal to hexadecimal
        assertEquals("123", Ex1.int2Number(123, 10)); // Decimal to decimal
        assertEquals("E4", Ex1.int2Number(228, 16)); // Larger hexadecimal
        assertEquals("110", Ex1.int2Number(6, 2)); // Decimal to binary
    }

    /**
     * Tests the int2Number method with invalid base.
     */
    @Test
    void testInt2Number_InvalidCases() {
        assertThrows(IllegalArgumentException.class, () -> Ex1.int2Number(5, 1)); // Base less than 2
        assertThrows(IllegalArgumentException.class, () -> Ex1.int2Number(5, 17)); // Base greater than 16
    }

    /**
     * Tests the maxIndex method to find the index of the largest number.
     */
    @Test
    void testMaxIndex() {
        String[] numbers = {"101b2", "A1b16", "123b10", "EFbG"};
        assertEquals(3, Ex1.maxIndex(numbers)); // Largest number index

        String[] numbers2 = {"101b2", "110b2", "123b10"};
        assertEquals(2, Ex1.maxIndex(numbers2)); // Last number is the largest
    }

    /**
     * Validates complex cases with specific inputs and operations.
     */
    @Test
    void testComplexCase() {
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

    /**
     * Tests edge cases for maximum values.
     */
    @Test
    void testEdgeCases() {
        String maxDecimal = "2147483647b10"; // Max int value
        String maxHex = "7FFFFFFFb16"; // Max int value in hexadecimal
        String maxBinary = "1111111111111111111111111111111b2"; // Max int in binary

        assertEquals(Integer.MAX_VALUE, Ex1.number2Int(maxDecimal));
        assertEquals(Integer.MAX_VALUE, Ex1.number2Int(maxHex));
        assertEquals(Integer.MAX_VALUE, Ex1.number2Int(maxBinary));
    }
}

package assignments.ex1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex1Test {

    @Test
    void testIsNumberWithSpaces() {
        assertTrue(Ex1.isNumber(" 101b2 ")); // Leading and trailing spaces
        assertTrue(Ex1.isNumber("123b10"));  // No spaces

        assertFalse(Ex1.isNumber(" ")); // Only spaces
        assertFalse(Ex1.isNumber(" 123b 10 ")); // Spaces around base
    }

    @Test
    void testIsNumber_ValidCases() {
        assertTrue(Ex1.isNumber("1001b2"));
        assertTrue(Ex1.isNumber("123b10"));
        assertTrue(Ex1.isNumber("A1b16"));
    }

    @Test
    void testIsNumber_InvalidCases() {
        assertFalse(Ex1.isNumber(null));
        assertFalse(Ex1.isNumber(""));
        assertFalse(Ex1.isNumber("12b1"));
        assertFalse(Ex1.isNumber("G12b16"));
        assertFalse(Ex1.isNumber("123"));
        assertFalse(Ex1.isNumber("12 b10"));
    }

    @Test
    void testNumber2Int() {
        assertEquals(257, Ex1.number2Int("101b16"));
        assertEquals(9, Ex1.number2Int("1001b2"));
        assertEquals(123, Ex1.number2Int("123b10"));
    }

    @Test
    void testInt2Number() {
        assertEquals("101", Ex1.int2Number(257, 16));
        assertEquals("1001", Ex1.int2Number(9, 2));
        assertEquals("123", Ex1.int2Number(123, 10));
    }

    @Test
    void testMaxIndex() {
        String[] numbers = {"1001b2", "101b16", "123b10"};
        assertEquals(1, Ex1.maxIndex(numbers));
    }
}

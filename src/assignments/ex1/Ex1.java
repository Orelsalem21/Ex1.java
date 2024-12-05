package assignments.ex1;

public class Ex1 {
    /**
     * Checks if a string is a valid number representation in the format <number><b><base>.
     * The format requires a number part and a base part separated by 'b', where the base is between 2 and 16.
     * Example: "A1b16", "1001b2".
     * @param str The input string.
     * @return True if the string is valid, false otherwise.
     */
    public static boolean isNumber(String str) {
        if (str == null || str.isEmpty()) return false;

        // Remove leading and trailing spaces manually
        int start = 0;
        int end = str.length() - 1;
        while (start <= end && str.charAt(start) == ' ') start++;
        while (end >= start && str.charAt(end) == ' ') end--;

        if (start > end) return false; // Only spaces

        str = str.substring(start, end + 1);

        if (!str.contains("b")) return false;

        String[] parts = str.split("b");
        if (parts.length != 2 || parts[0].isEmpty() || parts[1].isEmpty()) return false;

        String number = parts[0];
        int base;
        try {
            base = Integer.parseInt(parts[1]);
            if (base < 2 || base > 16) return false;
        } catch (NumberFormatException e) {
            return false;
        }

        for (char c : number.toCharArray()) {
            if (Character.digit(c, base) == -1) return false;
        }
        return true;
    }

    /**
     * Converts a valid number string to an integer based on its base.
     * @param num The valid number string (e.g., "A1b16").
     * @return The integer value of the number.
     */
    public static int number2Int(String num) {
        if (!isNumber(num)) throw new IllegalArgumentException("Invalid number format: " + num);

        String[] parts = num.split("b");
        String number = parts[0];
        int base = Integer.parseInt(parts[1]);

        int result = 0;
        for (char c : number.toCharArray()) {
            result = result * base + Character.digit(c, base);
        }
        return result;
    }

    /**
     * Converts an integer to a string representation in the given base.
     * @param num The integer to convert.
     * @param base The base for the output string.
     * @return The string representation of the number.
     */
    public static String int2Number(int num, int base) {
        if (base < 2 || base > 16) throw new IllegalArgumentException("Base must be between 2 and 16");
        return Integer.toString(num, base).toUpperCase();
    }

    /**
     * Finds the index of the maximum number in an array of number strings.
     * @param arr Array of valid number strings.
     * @return The index of the maximum number.
     */
    public static int maxIndex(String[] arr) {
        int maxIndex = -1;
        int maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int value = number2Int(arr[i]);
            if (value > maxValue) {
                maxValue = value;
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}

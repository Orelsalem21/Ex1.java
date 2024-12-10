package assignments.ex1;

/**
 * This class represents a simple solution for Ex1.
 * Numbers are represented as Strings with the format: <number><b><base>
 * Examples: "101b2", "A1b16", "123", "EFbG".
 */
public class Ex1 {

    /**
     * Convert the given number (num) to a decimal representation (as int).
     * If the given number is not in a valid format, returns -1.
     * @param num a String representing a number in basis [2,16]
     * @return the decimal representation of the number
     */
    public static int number2Int(String num) {
        if (num == null || num.isEmpty()) return -1;

        if (!isNumber(num)) return -1;

        if (!num.contains("b")) { 
            int result = 0;
            for (char c : num.toCharArray()) {
                result = result * 10 + (c - '0');
            }
            return result;
        }

        String[] parts = num.split("b");
        int base = parseBase(parts[1]);
        int result = 0;
        for (char c : parts[0].toCharArray()) {
            result = result * base + Character.digit(c, base);
        }
        return result;
    }

    /**
     * This static function checks if the given String (a) is in a valid "number" format.
     * @param a a String representing a number
     * @return true if the given String is in a valid number format
     */
    public static boolean isNumber(String a) {
        if (a == null || a.isEmpty()) return false;

        int start = 0, end = a.length() - 1;
        while (start <= end && a.charAt(start) == ' ') start++;
        while (end >= start && a.charAt(end) == ' ') end--;
        if (start > end) return false;

        String trimmed = a.substring(start, end + 1);

        if (!trimmed.contains("b")) { 
            for (char c : trimmed.toCharArray()) {
                if (!Character.isDigit(c)) return false;
            }
            return true;
        }

        String[] parts = trimmed.split("b");
        if (parts.length != 2 || parts[0].isEmpty() || parts[1].isEmpty()) return false;

        int base = parseBase(parts[1]);
        if (base < 2 || base > 16) return false;

        for (char c : parts[0].toCharArray()) {
            if (Character.digit(c, base) == -1) return false;
        }
        return true;
    }

    /**
     * Calculate the number representation (in basis base)
     * of the given natural number (represented as an integer).
     * @param num the natural number (including 0)
     * @param base the basis [2,16]
     * @return a String representing a number in the given base, or an empty String if input is invalid
     */
    public static String int2Number(int num, int base) {
        if (num < 0 || base < 2 || base > 16) return "";
        return Integer.toString(num, base).toUpperCase();
    }

    /**
     * This static function searches for the array index with the largest number (in value).
     * @param arr an array of numbers
     * @return the index in the array with the largest number (in value), or -1 if invalid
     */
    public static int maxIndex(String[] arr) {
        int maxValue = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            int value = (arr[i] == null || !isNumber(arr[i])) ? -1 : number2Int(arr[i]);
            if (value > maxValue) {
                maxValue = value;
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    private static int parseBase(String baseStr) {
        if (baseStr.matches("[A-G]")) { 
            return 10 + (baseStr.charAt(0) - 'A');
        } else {
            try {
                return Integer.parseInt(baseStr);
            } catch (NumberFormatException e) {
                return -1;
            }
        }
    }
}

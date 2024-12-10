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

        try {
            if (!num.contains("b")) {
                return Integer.parseInt(num.trim());
            }

            String[] parts = num.split("b");
            if (parts.length != 2) return -1;

            int base = parseBase(parts[1].trim());
            if (base < 2 || base > 16) return -1;

            return Integer.parseInt(parts[0], base);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * Checks if the given String (a) is in a valid "number" format.
     * @param a a String representing a number
     * @return true if the given String is in a valid number format
     */
    public static boolean isNumber(String a) {
        if (a == null || a.isEmpty()) return false;

        a = a.trim();
        if (!a.contains("b")) {
            return a.chars().allMatch(Character::isDigit);
        }

        String[] parts = a.split("b");
        if (parts.length != 2 || parts[0].isEmpty() || parts[1].isEmpty()) return false;

        int base = parseBase(parts[1].trim());
        if (base < 2 || base > 16) return false;

        return parts[0].chars().allMatch(c -> Character.digit(c, base) != -1);
    }

    /**
     * Converts a given integer to a number in a specified base.
     * @param num the natural number (including 0)
     * @param base the basis [2,16]
     * @return a String representing a number in the given base, or an empty String if input is invalid
     */
    public static String int2Number(int num, int base) {
        if (num < 0 || base < 2 || base > 16) return "";
        return Integer.toString(num, base).toUpperCase();
    }

    /**
     * Finds the index of the largest number in the array.
     * @param arr an array of numbers
     * @return the index of the largest number, or -1 if invalid
     */
    public static int maxIndex(String[] arr) {
        if (arr == null || arr.length == 0) return -1;

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

    /**
     * Parses a base string into an integer.
     * @param baseStr the base as a String
     * @return the parsed base or -1 if invalid
     */
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

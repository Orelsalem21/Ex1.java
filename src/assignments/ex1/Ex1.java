package assignments.ex1;

/**
 * This class provides utility methods for converting and calculating formatted numbers.
 */
public class Ex1 {
    public static int number2Int(String num) {
        if (!isNumber(num)) return -1;
        String[] parts = num.split("b");
        int base = parseBase(parts[1]);
        int result = 0;
        for (char c : parts[0].toCharArray()) result = result * base + Character.digit(c, base);
        return result;
    }
    public static boolean isNumber(String a) {
        if (a == null || !a.contains("b")) return false;
        String[] parts = a.split("b");
        if (parts.length != 2 || parts[0].isEmpty() || parts[1].isEmpty()) return false;

        int base = parseBase(parts[1]);
        if (base < 2 || base > 16) return false;

        for (char c : parts[0].toCharArray()) {
            if (Character.digit(c, base) == -1) return false;
        }
        return true;
    }
    public static String int2Number(int num, int base) {
        if (num < 0 || base < 2 || base > 16) return "";
        return Integer.toString(num, base).toUpperCase();
    }

    public static boolean equals(String n1, String n2) {
        // Not implemented as per assignment requirements
        throw new UnsupportedOperationException("This function is not implemented.");
    }

    public static int maxIndex(String[] arr) {
        if (arr.length == 0) throw new IllegalArgumentException("Empty array!");
        int maxValue = Integer.MIN_VALUE, maxIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            int value = number2Int(arr[i]);
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

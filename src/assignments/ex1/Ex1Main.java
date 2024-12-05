package assignments.ex1;

import java.util.Scanner;

public class Ex1Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program):");
            String num1 = scanner.nextLine();
            if (num1.equalsIgnoreCase("quit")) {
                running = false;
                System.out.println("Exiting program...");
                continue;
            }

            if (!Ex1.isNumber(num1)) {
                System.out.println("ERR: num1 is in the wrong format! (" + num1 + ")");
                continue;
            } else {
                System.out.println("num1 is valid: true");
            }

            boolean validNum2 = false;
            String num2 = "";
            while (!validNum2 && running) {
                System.out.println("Enter a string as number#2 (or \"quit\" to end the program):");
                num2 = scanner.nextLine();
                if (num2.equalsIgnoreCase("quit")) {
                    running = false;
                    System.out.println("Exiting program...");
                } else if (!Ex1.isNumber(num2)) {
                    System.out.println("ERR: num2 is in the wrong format! (" + num2 + ")");
                } else {
                    validNum2 = true;
                    System.out.println("num2 is valid: true");
                }
            }

            if (!running) continue;

            System.out.println("Enter a base for output: (a number [2,16]):");
            int base;
            try {
                base = Integer.parseInt(scanner.nextLine());
                if (base < 2 || base > 16) throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.out.println("Invalid base! Please enter a number between 2 and 16.");
                continue;
            }

            processNumbers(num1, num2, base);
        }

        scanner.close();
    }

    /**
     * Processes the two input numbers and prints their sum, product, and the maximum value.
     * @param num1 The first number string.
     * @param num2 The second number string.
     * @param base The base for the output.
     */
    private static void processNumbers(String num1, String num2, int base) {
        int value1 = Ex1.number2Int(num1);
        int value2 = Ex1.number2Int(num2);

        System.out.println("num1= " + num1 + " is number: true , value: " + value1);
        System.out.println("num2= " + num2 + " is number: true , value: " + value2);

        String sumStr = Ex1.int2Number(value1 + value2, base) + "b" + base;
        String productStr = Ex1.int2Number(value1 * value2, base) + "b" + base;

        System.out.println(num1 + " + " + num2 + " = " + sumStr);
        System.out.println(num1 + " * " + num2 + " = " + productStr);

        String[] numbers = {num1, num2, sumStr, productStr};
        int maxIdx = Ex1.maxIndex(numbers);
        System.out.println("Max number over " + String.join(",", numbers) + " is: " + numbers[maxIdx]);
    }
}

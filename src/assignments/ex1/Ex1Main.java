package assignments.ex1;

import java.util.Scanner;

import static java.lang.System.*;

public class Ex1Main {

    /**
     * The main function that handles user input and operations.
     * @param args command-line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean continueProgram = true;
        while (continueProgram) {
            out.println("Ex1 class solution:");

            // Input for the first number
            out.println("Enter a string as number#1 (or \"quit\" to end the program):");
            String input = scanner.next();
            if (input.equalsIgnoreCase("quit")) {
                out.println("Exiting program...");
                continueProgram = false;
            } else {
                // Validate the first number
                boolean isValidNum1 = Ex1.isNumber(input);
                int num1Value = isValidNum1 ? Ex1.number2Int(input) : -1;
                out.println("num1= " + input + " is number: " + isValidNum1 + " , value: " + num1Value);

                if (!isValidNum1) {
                    out.println("ERR: num1 is in the wrong format! (" + input + ")");
                } else {
                    // Input for the second number
                    out.println("Enter a string as number#2 (or \"quit\" to end the program):");
                    String num2Input = scanner.next();
                    if (num2Input.equalsIgnoreCase("quit")) {
                        out.println("Exiting program...");
                        continueProgram = false;
                    } else {
                        // Validate the second number
                        boolean isValidNum2 = Ex1.isNumber(num2Input);
                        int num2Value = isValidNum2 ? Ex1.number2Int(num2Input) : -1;
                        out.println("num2= " + num2Input + " is number: " + isValidNum2 + " , value: " + num2Value);

                        if (!isValidNum2) {
                            out.println("ERR: num2 is in the wrong format! (" + num2Input + ")");
                        } else {
                            // Input for the base
                            out.println("Enter a base for output: (a number [2,16]):");
                            int base = getValidBase(scanner);

                            // Perform calculations
                            String sum = Ex1.int2Number(num1Value + num2Value, base) + "b" + base;
                            String product = Ex1.int2Number(num1Value * num2Value, base) + "b" + base;

                            // Display results
                            out.println(input + " + " + num2Input + " = " + sum);
                            out.println(input + " * " + num2Input + " = " + product);

                            // Find and display the maximum
                            String[] numbers = {input, num2Input, sum, product};
                            int maxIdx = Ex1.maxIndex(numbers);
                            out.println("Max number over [" + String.join(",", numbers) + "] is: " + numbers[maxIdx]);
                        }
                    }
                }
            }
        }

        scanner.close();
    }

    /**
     * Prompts the user for a valid base between 2 and 16.
     * @param scanner Scanner object for user input.
     * @return A valid base.
     */
    private static int getValidBase(Scanner scanner) {
        int base = -1;
        while (base < 2 || base > 16) {
            try {
                base = Integer.parseInt(scanner.next());
                if (base < 2 || base > 16) {
                    out.println("Invalid base! Please enter a number between 2 and 16:");
                }
            } catch (NumberFormatException e) {
                out.println("Invalid base! Please enter a valid number between 2 and 16:");
            }
        }
        return base;
    }
}

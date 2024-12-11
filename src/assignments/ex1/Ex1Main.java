package assignments.ex1;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.*;

public class Ex1Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);

        while (true) {
            out.println("Ex1 class solution:");

            // Input for the first number or quit command
            out.println("Enter a string as number#1 (or \"quit\" to end the program):");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("quit")) {
                out.println("Exiting program...");
                break;
            }
            // Validate the first number
            if (!Ex1.isNumber(input)) {
                out.println("num1= " + input + " is number: false");
                continue;
            }
            int num1Value = Ex1.number2Int(input);
            out.println("num1= " + input + " is number: true , value: " + num1Value);
            // Check if the input contains all three required parts
            if (input.split("\\s+").length >= 3) {
                handleSingleLineInput(input);
            } else {
                // Ask for the second number
                out.println("Enter a string as number#2 (or \"quit\" to end the program):");
                var num2Input = scanner.nextLine();
                if (num2Input.equalsIgnoreCase("quit")) {
                    out.println("Exiting program...");
                    break;
                }

                // Validate the first number
                if (!Ex1.isNumber(input)) {
                    out.println("num1= " + input + " is number: false");
                    continue;
                }
                // Validate the second number
                if (!Ex1.isNumber(num2Input)) {
                    out.println("num2= " + num2Input + " is number: false");
                    continue;
                }
                int num2Value = Ex1.number2Int(num2Input);
                out.println("num2= " + num2Input + " is number: true , value: " + num2Value);

                // Ask for the base
                out.println("Enter a base for output: (a number [2,16]):");
                int base = getValidBase(scanner);

                // Perform calculations
                var sum = Ex1.int2Number(num1Value + num2Value, base) + "b" + base;
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

        scanner.close();
    }

    /**
     * Handles single-line input containing all three parts: num1, num2, and base.
     * @param input The input string containing the three parts.
     */
    private static void handleSingleLineInput(String input) {
        String[] inputs = input.split("\\s+");
        if (inputs.length < 3) {
            out.println("Invalid input! Please provide at least 3 values: num1, num2, and base.");
            return;
        }

        String num1Input = inputs[0];
        String num2Input = inputs[1];
        String baseInput = inputs[2];

        // Validate num1
        if (!Ex1.isNumber(num1Input)) {
            out.println("num1= " + num1Input + " is number: false");
            return;
        }
        int num1Value = Ex1.number2Int(num1Input);
        out.println("num1= " + num1Input + " is number: true , value: " + num1Value);

        // Validate num2
        if (!Ex1.isNumber(num2Input)) {
            out.println("num2= " + num2Input + " is number: false");
            return;
        }
        int num2Value = Ex1.number2Int(num2Input);
        out.println("num2= " + num2Input + " is number: true , value: " + num2Value);

        // Validate base
        int base;
        try {
            base = Integer.parseInt(baseInput);
            if (base < 2 || base > 16) {
                out.println("Invalid base! Please provide a base between 2 and 16.");
                return;
            }
        } catch (NumberFormatException e) {
            out.println("Invalid base! Please provide a valid number between 2 and 16.");
            return;
        }

        // Perform calculations
        String sum = Ex1.int2Number(num1Value + num2Value, base) + "b" + base;
        var product = Ex1.int2Number(num1Value * num2Value, base) + "b" + base;

        // Display results
        for (String s : Arrays.asList(num1Input + " + " + num2Input + " = " + sum, num1Input + " * " + num2Input + " = " + product)) {
            out.println(s);
        }

        // Find and display the maximum
        String[] numbers = {num1Input, num2Input, sum, product};
        int maxIdx = Ex1.maxIndex(numbers);
        out.println("Max number over [" + String.join(",", numbers) + "] is: " + numbers[maxIdx]);
    }

    /**
     * Prompts the user for a valid base between 2 and 16.
     * @param scanner Scanner object for user input.
     * @return A valid base.
     */
    private static int getValidBase(Scanner scanner) {
        while (true) {
            String baseInput = scanner.nextLine();
            try {
                int base = Integer.parseInt(baseInput);
                if (base >= 2 && base <= 16) {
                    return base;
                }
                out.println("Invalid base! Please enter a number between 2 and 16:");
            } catch (NumberFormatException e) {
                out.println("Invalid base! Please enter a valid number between 2 and 16:");
            }
        }
    }
}

package assignments.ex1;

import java.util.Scanner;

public class Ex1Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Enter a number in the format '<number>b<base>' or 'quit' to exit:");
            String num1 = scanner.nextLine();
            if (num1.equalsIgnoreCase("quit")) {
                System.out.println("Exiting program...");
                break;
            }
            if (!Ex1.isNumber(num1)) {
                System.out.println("Invalid input! Please enter a valid formatted number.");
                continue;
            }

            int decimalValue1 = Ex1.number2Int(num1);
            System.out.println("The decimal value of " + num1 + " is: " + decimalValue1);

            System.out.println("Enter a string as number#2 (or 'quit' to exit):");
            String num2 = scanner.nextLine();
            if (num2.equalsIgnoreCase("quit")) {
                System.out.println("Exiting program...");
                break;
            }
            if (!Ex1.isNumber(num2)) {
                System.out.println("Invalid input! Please enter a valid formatted number.");
                continue;
            }

            int decimalValue2 = Ex1.number2Int(num2);
            System.out.println("The decimal value of " + num2 + " is: " + decimalValue2);

            System.out.println("Enter a base for output: (a number [2,16]):");
            int base;
            try {
                base = Integer.parseInt(scanner.nextLine());
                if (base < 2 || base > 16) throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.out.println("Invalid base! Please enter a number between 2 and 16.");
                continue;
            }

            String sum = Ex1.int2Number(decimalValue1 + decimalValue2, base) + "b" + base;
            String product = Ex1.int2Number(decimalValue1 * decimalValue2, base) + "b" + base;

            System.out.println(num1 + " + " + num2 + " = " + sum);
            System.out.println(num1 + " * " + num2 + " = " + product);

            String[] numbers = {num1, num2, sum, product};
            int maxIdx = Ex1.maxIndex(numbers);
            System.out.println("Max number over [" + String.join(",", numbers) + "] is: " + numbers[maxIdx]);
        }

        scanner.close();
    }
}

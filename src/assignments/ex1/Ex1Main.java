package assignments.ex1;

import java.util.Scanner;

public class Ex1Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Ex1 class solution:");
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program):");
            String input1 = scanner.nextLine();

            if (input1.equalsIgnoreCase("quit")) {
                System.out.println("Exiting program...");
                break;
            } else if (!Ex1.isNumber(input1)) {
                System.out.println("num1= " + input1 + " is number: false");
                continue;
            }

            int num1Value = Ex1.number2Int(input1);
            System.out.println("num1= " + input1 + " is number: true , value: " + num1Value);

            System.out.println("Enter a string as number#2 (or \"quit\" to end the program):");
            String input2 = scanner.nextLine();

            if (input2.equalsIgnoreCase("quit")) {
                System.out.println("Exiting program...");
                break;
            } else if (!Ex1.isNumber(input2)) {
                System.out.println("num2= " + input2 + " is number: false");
                continue;
            }

            int num2Value = Ex1.number2Int(input2);
            System.out.println("num2= " + input2 + " is number: true , value: " + num2Value);

            System.out.println("Enter a base for output: (a number [2,16]):");
            String baseInput = scanner.nextLine();

            try {
                int base = Integer.parseInt(baseInput);
                if (base < 2 || base > 16) {
                    System.out.println("Invalid base! Please enter a number between 2 and 16.");
                } else {
                    String sum = Ex1.int2Number(num1Value + num2Value, base) + "b" + base;
                    String product = Ex1.int2Number(num1Value * num2Value, base) + "b" + base;

                    System.out.println(input1 + " + " + input2 + " = " + sum);
                    System.out.println(input1 + " * " + input2 + " = " + product);

                    String[] numbers = {input1, input2, sum, product};
                    int maxIdx = Ex1.maxIndex(numbers);
                    System.out.println("Max number over [" + String.join(",", numbers) + "] is: " + numbers[maxIdx]);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid base! Please enter a valid number.");
            }
        }

        scanner.close();
    }
}

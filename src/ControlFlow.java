import java.text.NumberFormat;
import java.util.Scanner;

public class ControlFlow {
    public static void comparisonAndLogicalOperators() {
        //  like javascript
        int x = 1;
        int y = 1;
        System.out.println(x == y); // true
        System.out.println(x != y); // false

        int temperature = 22;
        boolean isWarm = temperature > 20 && temperature < 30;
        System.out.println(isWarm);  // true

        boolean hashighIncome = true;
        boolean hasGoodCredit = true;
        boolean isEligible = hashighIncome || hasGoodCredit;
        System.out.println(isEligible); // true

        boolean hasCrimialRecord = true;
        boolean isEligible2 = (hashighIncome || hasGoodCredit) && !hasCrimialRecord;
        System.out.println(isEligible2); // false
    }

    public static void ifStatement() {
            int temp = 32;
            if (temp > 30) {
                System.out.println("It's a hot day");
                System.out.println("Drink more water!");
            }
            else if (temp > 20)
                System.out.println("Beautiful day");
            else
                System.out.println("Cold day");

            int income = 100_000_000;
            boolean hasHighIncome = income > 100_000; // simplify
            System.out.println(hasHighIncome); // true

            String className = income > 100_000 ? "First" : "Economy"; // ternary operator
            System.out.println(className); // "First"
    }

    public static void switchStatement() {
        String role = "admin";
        switch (role) {
            case "admin":
                System.out.println("You're an admin!");
                break;
            case "moderator":
                System.out.println("You're a moderator!");
                break;
            default:
                System.out.println("You're a guest!");
        }
        // "You're an admin!"
    }

    public static void FizzBuzz() {
        final byte fizz = 5;
        final String fizzOutput = "Fizz";
        final byte buzz = 3;
        final String buzzOutput = "Buzz";

        System.out.print("Input: ");
        Scanner scanner = new Scanner(System.in);

        int input = scanner.nextInt();

        String output = "";
        if (input % fizz == 0) {
            output += fizzOutput;
        }
        if (input % buzz == 0) {
            output += buzzOutput;
        }
        if (output.isEmpty())
            System.out.println(input);
        else
            System.out.println(output);
    }

    public static void ForLoops() {
        for (int i = 0; i < 5; i++)
            System.out.println("Hello " + i);
        // Hello 0
        // Hello 1
        // Hello 2
        // Hello 3
        // Hello 4
    }

    public static void WhileLoops() {
        int i = 3;
        while (i >= 0) {
            System.out.println("Hello " + i);
            i--;
        }
        // Hello 3
        // Hello 2
        // Hello 1
        // Hello 0

        Scanner scanner = new Scanner(System.in);
        String input = "";

        // check condition first
        while (!input.equals("quit")) { // because String is a reference type, input == "quit" can't work.
            System.out.print("Input: ");
            input = scanner.next().toLowerCase();
            if (input.equals("pass"))
                continue;
            if (input.equals("quit"))
                break;
            System.out.println("Your input is: " + input);
        }

        // do at least once
        do {
            System.out.print("Input: ");
            input = scanner.next().toLowerCase();
            if (input.equals("pass"))
                continue;
            if (input.equals("quit"))
                break;
            System.out.println("Your input is: " + input);
        } while (true); // because the statement inside has break condition
    }

    public static void ForEachLoop() {
        String[] fruits = { "Apple", "Mango", "Orange" };

        for (String fruit : fruits)
            System.out.println(fruit);
        // Apple
        // Mango
        // Orange
    }

    public static void OptimizedMortgageCalculator() {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);

        float principal = 0;
        final int MIN_PRINCIPAL = 1000;
        final int MAX_PRINCIPAL = 1_000_000;
        while (true) {
            System.out.print("Principal: ");
            principal = scanner.nextFloat();
            if (principal >= MIN_PRINCIPAL && principal <= MAX_PRINCIPAL)
                break;
            System.out.printf("Enter a value between %d and %d", MIN_PRINCIPAL, MAX_PRINCIPAL);
            System.out.println();
        }

        float annualInterest = 0;
        final int MIN_ANNUAL_INTEREST = 1;
        final int MAX_ANNUAL_INTEREST = 30;
        double monthlyInterest = 0;
        while (true) {
            System.out.print("Annual Interest Rate: ");
            annualInterest = scanner.nextFloat();
            if (annualInterest >= MIN_ANNUAL_INTEREST && annualInterest <= MAX_ANNUAL_INTEREST) {
                monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
                break;
            }
            System.out.printf("Enter a value between %d and %d", MIN_ANNUAL_INTEREST, MAX_ANNUAL_INTEREST);
            System.out.println();
        }

        int years = 0;
        final int MIN_YEARS = 1;
        final int MAX_YEARS = 30;
        int numberOfPayments = 0;
        while (true) {
            System.out.print("Period (Years): ");
            years = scanner.nextInt();
            if (years >= MIN_YEARS && years <= MAX_YEARS) {
                numberOfPayments = years * MONTHS_IN_YEAR;
                break;
            }
            System.out.printf("Enter a value between %d and %d", MIN_YEARS, MAX_YEARS);
            System.out.println();
        }

        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
        System.out.println("Mortgage: " + NumberFormat.getCurrencyInstance().format(mortgage));
    }

    public static void StringFormat() {
        String.format("String: %s", "text");        // String
        String.format("Integer: %d", 42);           // Integer
        String.format("Float: %.2f", 3.14159);      // Float with 2 decimal places
        String.format("Boolean: %b", true);         // Boolean
        String.format("Character: %c", 'A');        // Character
        String.format("Multiple: %s, %d", "text", 42); // Multiple values
    }
}

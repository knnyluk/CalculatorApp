package com.example.calculatorapp;

import java.util.Scanner;
public class CalculatorApp {
    public static Scanner userInput = new Scanner(System.in);
    static int lowValidOp = 1;
    static int highValidOp = 5;

    public static int getMathOp() {
        printOperationPrompt();
        while (!userInput.hasNextInt()) {
            System.out.println("\nSorry, only digits are valid choices\n\n" +
                    "Please try again.\n");
            printOperationPrompt();
            userInput.next();
        }
        int inputNum = userInput.nextInt();
        if (invalidOpSelection(inputNum)) {
            System.out.println("\nYour number must be between 1 and 4.\n\n");
            return getMathOp();
        }
        return inputNum;
    }

    public static double[] getTwoDoubles() {
        double[] result = new double[2];
        result[0] = getValidDouble();
        System.out.println("\nAnother number please.\n");
        result[1] = getValidDouble();
        return result;
    }

    public static double getValidDouble() {
        while (!userInput.hasNextDouble()) {
            System.out.println("\nI need a number.\n" +
                               "Please try again.\n\n");
            userInput.next();
        }
        return userInput.nextDouble();
    }

    private static boolean invalidOpSelection(int selection) {
        return (selection < lowValidOp || selection > highValidOp);
    }

    public static void printOperationPrompt() {
        System.out.println("Which math operation would you like to perform?\n\n" +
                           "    1.) Addition\n" +
                           "    2.) Subtraction\n" +
                           "    3.) Multiplicaiton\n" +
                           "    4.) Division\n" +
                           "    5.) Square root\n");
    }

    public static void printSum(double[] numbers) {
        System.out.println("The sum of " + numbers[0] + " and " + numbers[1] + " is: " + (numbers[0] + numbers[1]));
    }

    public static void printDifference(double[] numbers) {
        System.out.println("The difference of " + numbers[0] + " and " + numbers[1] + " is: " + (numbers[0] - numbers[1]));
    }

    public static void printSqRt(double inputNum) {
        System.out.println("\nThe square root of " + inputNum + " is " + Math.sqrt(inputNum) + "\n");
    }

    public static void main(String[] args) {
        int opSelection = getMathOp();
        String[] dummyArray = {};

        switch (opSelection) {
            case 1: System.out.println("So, adding is your thing, eh?\n\n" +
                                       "I need a number to get started\n");
                    printSum(getTwoDoubles());
                    break;
            case 2: System.out.println("Subtraction?\n" +
                                       "There's a high correlation between positivity and life expectancy.\n" +
                                       "So, maybe being more positive is a good idea. Anyway . . .\n\n" +
                                       "I need a number to get started\n");
                    printDifference(getTwoDoubles());
                    break;
            case 3:
            case 4:
                break;
            case 5: System.out.println("\nTo do this square root thing I'm going to need a number\n");
                    printSqRt(getValidDouble());
        }
        main(dummyArray);
//        System.out.println(getMathOp());
//        System.out.println("");
    }
}

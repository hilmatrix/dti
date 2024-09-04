package com.hilmatrix.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExerciseDay3 {
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        int taskSelection;

        while (true) {
            System.out.println("---------------------------");
            System.out.println("Exercise Day 3. Select 0 to exit");
            System.out.println("1) calculate sum digit. 2) check number is prime");
            System.out.println("3) find largest number. 4) simple calculator");
            System.out.println("5) reverse string.      6) Fibonnaci");
            System.out.println("7) count vowels.        8) bubble sort");
            System.out.println("9) anagram.             10) second smallest value");

            try {
                System.out.print("Select task number : ");
                taskSelection = scanner.nextInt();
            } catch (Exception e) {
                scanner = new Scanner(System.in);
                continue;
            }

            scanner = new Scanner(System.in);

            switch (taskSelection) {
                case 1: runTask1countDigit(scanner); break;
                case 2: runTask2checkIsPrime(scanner); break;
                case 3: runTask3findLargest(scanner); break;
                case 5: runTask5reverseString(scanner); break;
                case 6: runTask6Fibonacci(scanner); break;
                case 7: runTask7vowels(scanner); break;
                case 8: runTask8bubbleSort(scanner); break;
            }

            if (taskSelection == 0)
                break;
        }
    }

    public static void runTask1countDigit(Scanner scanner) {
        System.out.print("Input number : ");
        int number = scanner.nextInt();
        int count = 0;
        while (number > 0) {
            count += number % 10;
            number = number / 10;
        }
        System.out.println("Output : Digit count is " + count);
    }

    public static void runTask2checkIsPrime(Scanner scanner) {
        System.out.print("Input number : ");
        int number = scanner.nextInt();
        boolean isPrime = true;

        if (number < 2)
            isPrime = false;
        else {
            for (int loop = 2; loop <= Math.sqrt(number); loop++) {
                if (number % loop == 0) {
                    isPrime = false;
                    break;
                }
            }
        }

        String resultStr = " not a prime";
        if (isPrime)
            resultStr = " is a prime";

        System.out.println("Output : " + number + resultStr);
    }

    public static void runTask3findLargest(Scanner scanner) {
        System.out.print("Input number separated by comma : ");

        String strNumber = scanner.nextLine();
        String[] strNumberArray = strNumber.replaceAll(" ", "").split(",");
        int currentValue = Integer.valueOf(strNumberArray[0]);

        if (strNumberArray.length > 1) {
            for (int loop = 1; loop < strNumberArray.length; loop++) {
                int nextValue = Integer.valueOf(strNumberArray[loop]);
                if (currentValue < nextValue)
                    currentValue = nextValue;
            }
        }

        System.out.println("Output : The highest number is " + currentValue);
    }

    public static void runTask4simpleCalculator(Scanner scanner) {
        System.out.print("Input expression : ");

        String strInput = scanner.nextLine().replaceAll(" ","");
        int operand1 = 0;
        int operand2 = 0;
        char operator = '+';
        String strOperand ="";

        for (int loop = 0; loop < strInput.length(); loop++) {
            if (Character.isDigit(strInput.charAt(loop))) {
                strOperand += strInput.charAt(loop);
            } else if ((strInput.charAt(loop) == '+') || (strInput.charAt(loop) == '-'))  {
                operand2 = Integer.valueOf(strOperand);
                //operand1 += operand1
            }
        }

    }

    public static void runTask5reverseString(Scanner scanner) {
        System.out.print("Input string : ");

        String strInput = scanner.nextLine();
        String strOutput = "";
        for (int loop = strInput.length()-1; loop >= 0; loop--) {
            strOutput += strInput.charAt(loop);
        }

        System.out.println("Output : " + strOutput);
    }

    public static void runTask6Fibonacci(Scanner scanner) {
        System.out.print("Input fibonacci value : ");
        int result;

        int n = scanner.nextInt();
        int memory1 = 0;
        int memory2 = 1;

        if ((n < 1) || (n == 1)) {
            result = memory1;
        } else if (n == 2) {
            result = memory2;
        } else {
            for (int loop = 3; loop <= n; loop++) {
                int newMemory = memory1 + memory2;
                memory1 = memory2;
                memory2 = newMemory;
            }
            result = memory2;
        }

        System.out.println("Output : " + result);
    }

    public static void runTask7vowels(Scanner scanner) {
        System.out.print("Input sentence : ");

        String strInput = scanner.nextLine();

        String vowels = "aiueo";
        int vowelsCount = 0;

        for (int loop = 0; loop < strInput.length(); loop++) {
            if (vowels.contains(strInput.charAt(loop)+"")) {
                vowelsCount++;
            }
        }

        System.out.println("Output : " + vowelsCount);
    }

    public static void runTask8bubbleSort(Scanner scanner) {
        System.out.print("Input number separated by comma : ");

        String strNumber = scanner.nextLine();
        String[] strNumberArray = strNumber.replaceAll(" ", "").split(",");
        List<Integer> integerArray = new ArrayList<Integer>();

        if (strNumberArray.length > 1) {
            for (int loop = 0; loop < strNumberArray.length; loop++) {
                integerArray.add(Integer.valueOf(strNumberArray[loop]));
            }
        }

        int arrayLength = integerArray.size();

        for (int i = 0; i < arrayLength - 1; i++) {
            for (int j = 0; j < arrayLength - i - 1; j++) {
                if (integerArray.get(j) > integerArray.get(j + 1)) {
                    int temp = integerArray.get(j);
                    integerArray.set(j,  integerArray.get(j + 1));
                    integerArray.set(j + 1, temp);
                }
            }
        }

        System.out.println("Output : ");
        for (int num : integerArray) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

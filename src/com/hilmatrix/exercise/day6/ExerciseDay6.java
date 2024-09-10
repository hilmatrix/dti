package com.hilmatrix.exercise.day6;

import java.util.Scanner;

public class ExerciseDay6 {
    public static void start() {
        Scanner scanner = new Scanner(System.in);
        int taskSelection;

        while (true) {
            System.out.println("---------------------------");
            System.out.println("Exercise Day 6. Select 0 to exit");
            System.out.println("1) rotate array");
            System.out.println("2) has duplicates");
            System.out.println("3) remove duplicates");
            System.out.println("4) remove occurences");
            System.out.println("5) reverse string");
            System.out.println("6) find duplicates");

            try {
                System.out.print("Select task number : ");
                taskSelection = scanner.nextInt();
            } catch (Exception e) {
                scanner = new Scanner(System.in);
                continue;
            }

            scanner = new Scanner(System.in);

            switch (taskSelection) {
                case 1 : runTask1arrayRotation(scanner); break;
                case 2 : runTask2containDuplicates(scanner); break;
                case 3 : runTask3removeDuplicates(scanner); break;
                case 4 : runTask4removeOccurences(scanner); break;
                case 5 : runTask5reverseString(scanner); break;
                case 6 : runTask6findDuplicates(scanner);break;
            }

            if (taskSelection == 0)
                break;
        }
    }

    public static void runTask1arrayRotation(Scanner scanner) {
        int[] numberArray = numbeArrayReader(scanner);
        int[] shiftedArray = new int[numberArray.length];

        System.out.print("Input d number to rotate : ");
        int d = scanner.nextInt();
        d = d % numberArray.length;

        for (int loop = 0; loop < numberArray.length; loop++) {
            int nextIndex = (loop + d) % numberArray.length;
            shiftedArray[loop] = numberArray[nextIndex];
        }

        for (int value : shiftedArray) {
            System.out.println(value);
        }
    }

    public static void runTask2containDuplicates(Scanner scanner) {
        int[] numberArray = numbeArrayReader(scanner);
        bubbleSort(numberArray);
        if (numberArrayContainDuplicates(numberArray))
            System.out.println("Has duplicates");
        else
            System.out.println("No duplicates");
    }

    public static void runTask3removeDuplicates(Scanner scanner) {
        int[] numberArray = numbeArrayReader(scanner);
        bubbleSort(numberArray);
        int[] noDuplicatesArray = numberArrayRemoveDuplicates(numberArray);
        System.out.print("Output :");

        printArray(noDuplicatesArray);
    }

    public static void runTask4removeOccurences(Scanner scanner) {
        int[] integerArray = numbeArrayReader(scanner);

        System.out.print("Input value to remove : ");
        int key = scanner.nextInt();

        int[] filteredArray = removeOccurences(integerArray, key);
        printArray(filteredArray);
    }

    public static void runTask5reverseString(Scanner scanner) {
        System.out.print("Input string : ");
        System.out.println("Output : " + reverseString(scanner.nextLine()));
    }

    public static void runTask6findDuplicates(Scanner scanner) {
        int[] integerArray = numbeArrayReader(scanner);
        bubbleSort(integerArray);
        int[] duplicates = findDuplicates(integerArray);
        printArray(duplicates);
    }

    public static String reverseString(String input) {
        StringBuilder output = new StringBuilder();
        for (int loop = input.length() -1; loop >= 0 ; loop--) {
            output.append(input.charAt(loop));
        }
        return output.toString();
    }

    public static int[] findDuplicates(int[] integerArray) {
        int duplicates = 0;
        boolean skip = false;

        for (int loop = 1; loop < integerArray.length; loop++) {
            if (integerArray[loop - 1] != integerArray[loop])  {
                skip = false;
            } else if (!skip) {
                duplicates++;
                skip = true;
            }
        }

        int[] result = new int[duplicates];

        int resultIndex = 0;
        skip = false;
        for (int loop = 1; loop < integerArray.length; loop++) {
            if (integerArray[loop - 1] != integerArray[loop])  {
                skip = false;
            } else if (!skip) {
                result[resultIndex++] = integerArray[loop];
                skip = true;
            }
        }

        return result;
    }

    public static void printArray(int[] integerArray) {
        System.out.print("Output :");
        for (int i : integerArray) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static int[] numbeArrayReader(Scanner scanner) {
        System.out.print("Input number separated by space : ");

        String strNumber = scanner.nextLine();
        String[] strNumberArray = strNumber.split(" ");


        int[] numberArray = new int[strNumberArray.length];

        for (int loop = 0; loop < strNumberArray.length; loop++) {
            numberArray[loop] = Integer.parseInt(strNumberArray[loop]);
        }

        return numberArray;
    }


    public static int[] numberArrayRemoveDuplicates(int[] integerArray) {

        // count duplicates
        int duplicates = 0;
        for (int loop = 1; loop < integerArray.length; loop++) {
            if (integerArray[loop - 1] == integerArray[loop])  {
                duplicates++;
            }
        }

        // new array with length reduced by duplicates
        int[] result = new int[integerArray.length - duplicates];

        result[0] = integerArray[0];

        if (integerArray.length == 1) {
            return result;
        }

        // copying array without duplicates
        int resultIndex = 1;
        for (int loop = 1; loop < integerArray.length; loop++) {
            if (integerArray[loop - 1] != integerArray[loop])  {
                result[resultIndex++] = integerArray[loop];
            }
        }

        return result;
    }

    public static boolean numberArrayContainDuplicates(int[] integerArray) {
        if (integerArray.length <= 1)
            return false;

        for (int loop = 1; loop < integerArray.length; loop++) {
            if (integerArray[loop - 1] == integerArray[loop]) {
                return true;
            }
        }

        return false;
    }

    public static void bubbleSort(int[] integerArray) {
        int arrayLength = integerArray.length;
        for (int loopFirst = 0; loopFirst < arrayLength - 1; loopFirst++) {
            for (int loopSecond = 0; loopSecond < arrayLength - loopFirst - 1; loopSecond++) {
                if (integerArray[loopSecond] > integerArray[loopSecond + 1]) {
                    int temp = integerArray[loopSecond];
                    integerArray[loopSecond] = integerArray[loopSecond + 1];
                    integerArray[loopSecond + 1] = temp;
                }
            }
        }
    }

    public static int[] removeOccurences(int[] integerArray, int key) {
        int occurences = 0;
        for (int loopValue : integerArray) {
            if (loopValue == key)
                occurences++;
        }

        int[] result = new int[integerArray.length - occurences];

        int resultIndex = 0;
        for (int i : integerArray) {
            if (i != key)
                result[resultIndex++] = i;
        }

        return result;
    }
}

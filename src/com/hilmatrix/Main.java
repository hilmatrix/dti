package com.hilmatrix;
import java.util.Scanner;
import com.hilmatrix.exercise.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int exerciseSelection;

        while (true) {
            System.out.println("---------------------------");
            System.out.println("Hilmatrix Exercise Selector");
            System.out.println("Exercise available : 1-2. Select  0 to exit");
            System.out.println();
            try {
                System.out.print("Select exercise number : ");
                exerciseSelection = scanner.nextInt();
            } catch (Exception e) {
                scanner = new Scanner(System.in);
                continue;
            }

            try {
                switch (exerciseSelection) {
                    case 1:
                        Exercise1.run();
                        break;
                    case 2:
                        Exercise2.run();
                        break;
                }
            } catch (Exception e) {
                scanner = new Scanner(System.in);
                e.printStackTrace();
                System.out.println("Error at exercise " + exerciseSelection);
            }

            if (exerciseSelection == 0)
                break;
        }
    }
}

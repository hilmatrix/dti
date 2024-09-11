package com.hilmatrix.exercise.day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExerciseDay7 {
    public static void start() {
        Scanner scanner = new Scanner(System.in);
        int taskSelection;

        while (true) {
            System.out.println("---------------------------");
            System.out.println("Exercise Day 7. Select 0 to exit");
            System.out.println("Task 1 calculate average");
            System.out.println("Task 2 calculate summary");

            try {
                System.out.print("Select task number : ");
                taskSelection = scanner.nextInt();
            } catch (Exception e) {
                scanner = new Scanner(System.in);
                continue;
            }

            scanner = new Scanner(System.in);

            switch (taskSelection) {
                case 1 : runTask1calculateAverage(scanner); break;
                case 2 : runTask2dataSummary(); break;
            }

            if (taskSelection == 0)
                break;
        }
    }

    public static void runTask1calculateAverage(Scanner scanner) {
        System.out.println("Input number, enter q to finish");
        boolean quit = false;
        List<Integer> integerArray = new ArrayList<>();

        while (!quit) {
            String strInput = scanner.nextLine();

            try {
                int newInteger = Integer.parseInt(strInput);
                integerArray.add(newInteger);
            } catch (NumberFormatException e) {
                if (strInput.isBlank() || (strInput.charAt(0) != 'q') ){
                    System.out.println("Invalid input. Please input q to finish");
                } else {
                    quit = true;
                }
            }
        }

        if (integerArray.size() <= 0)
            return;

        double average = 0;
        for (int number : integerArray) {
            average += number;
        }
        System.out.println("Average = " + average);
    }

    public static void runTask2dataSummary() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = null;
        BufferedReader reader = null;

        try  {
            inputStream = classLoader.getResourceAsStream("product_sales_data.csv");
            if (inputStream == null) {
                System.out.println("Resource not found.");
                return;
            }

            reader = new BufferedReader(new InputStreamReader(inputStream));
            DataParser newData = new DataParser();

            boolean firstTime = true;

            // Lewati header
            String line = reader.readLine();

            double totalSales = 0;
            int productSold = 0;

            DataParser mostSoldProduct = null;
            DataParser leastSoldProduct = null;

            while ((line = reader.readLine()) != null) {
                try {
                    newData.parse(line);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Parsing Error");
                    continue;
                }


                if (firstTime) {
                    totalSales = newData.sold * newData.price;
                    productSold = newData.sold;

                    mostSoldProduct = new DataParser(newData);
                    leastSoldProduct = new DataParser(newData);

                    firstTime = false;
                    continue;
                }

                totalSales += newData.sold * newData.price;
                productSold += newData.sold;
                if (newData.sold < leastSoldProduct.sold) {
                    leastSoldProduct.copy(newData);
                }
                if (newData.sold > mostSoldProduct.sold) {
                    mostSoldProduct.copy(newData);
                }
            }

            System.out.printf("Total sales = %f\n",totalSales);
            System.out.println("Total product sold = " + productSold);
            System.out.println("Most Bought Product = " + mostSoldProduct.product);
            System.out.println("Least Bought Product = " + leastSoldProduct.product);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("File reading Error");
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("File closing Error");
            }
        }
    }

    public static class DataParser {
        String product;
        int sold;
        double price;

        public DataParser() {}

        public DataParser(DataParser newData) {
            copy(newData);
        }

        public void parse(String data) {
            String[] parts = data.split(",");

            product = parts[0];
            sold = Integer.parseInt(parts[1]);
            price = Float.parseFloat(parts[2]);
        }

        public void copy(DataParser newData) {
            this.product = newData.product;
            this.sold = newData.sold;
            this.price = newData.price;
        }
    }
}

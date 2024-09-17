package com.hilmatrix.exercise.day11;

import java.util.Scanner;

public class ExerciseDay11 {
    public static void start() {
        Scanner scanner = new Scanner(System.in);
        int taskSelection;

        while (true) {
            System.out.println("---------------------------");
            System.out.println("Exercise Day 11. Select 0 to exit");
            System.out.println("Task 1 test Stack class");
            System.out.println("Task 2 test Queue class");

            try {
                System.out.print("Select task number : ");
                taskSelection = scanner.nextInt();
            } catch (Exception e) {
                scanner = new Scanner(System.in);
                continue;
            }

            scanner = new Scanner(System.in);

            switch (taskSelection) {
                case 1 : runTask1testStack(); break;
                case 2 : runTask2testQueue(); break;
            }

            if (taskSelection == 0)
                break;
        }
    }

    public static void runTask1testStack() {
        Stack<Integer> stack = new Stack<>();

        System.out.println("Input number sequentially 1 20 300 4000 50000");
        stack.push(1);
        stack.push(20);
        stack.push(300);
        stack.push(4000);
        stack.push(50000);

        try {
            System.out.println("Stack peek output " + stack.peek());
            System.out.println("Stack pop output " + stack.pop());

            System.out.println("Stack peek output " + stack.peek());
            System.out.println("Stack pop output " + stack.pop());

            System.out.println("Stack peek output " + stack.peek());
            System.out.println("Stack pop output " + stack.pop());

            System.out.println("Stack peek output " + stack.peek());
            System.out.println("Stack pop output " + stack.pop());

            System.out.println("Stack peek output " + stack.peek());
            System.out.println("Stack pop output " + stack.pop());

            System.out.println("Stack peek output " + stack.peek());
            System.out.println("Stack pop output " + stack.pop());
        } catch (Exception e) {
            System.out.println("Stack error message : " + e.getMessage());
        }

        try {
            System.out.println("Stack pop output " + stack.pop());
        } catch (Exception e) {
            System.out.println("Stack error message : " + e.getMessage());
        }
    }

    public static void runTask2testQueue() {
        Queue<Integer> queue = new Queue<>();

        System.out.println("Input number sequentially 1 20 300 4000 50000");
        queue.enqueue(1);
        queue.enqueue(20);
        queue.enqueue(300);
        queue.enqueue(4000);
        queue.enqueue(50000);

        try {
            System.out.println("Queue enqueue output " + queue.peek());
            System.out.println("Queue dequeue output " + queue.dequeue());

            System.out.println("Queue enqueue output " + queue.peek());
            System.out.println("Queue dequeue output " + queue.dequeue());

            System.out.println("Queue enqueue output " + queue.peek());
            System.out.println("Queue dequeue output " + queue.dequeue());

            System.out.println("Queue enqueue output " + queue.peek());
            System.out.println("Queue dequeue output " + queue.dequeue());

            System.out.println("Queue enqueue output " + queue.peek());
            System.out.println("Queue dequeue output " + queue.dequeue());

            System.out.println("Queue enqueue output " + queue.peek());
            System.out.println("Queue dequeue output " + queue.dequeue());
        } catch (Exception e) {
            System.out.println("Queue error message : " + e.getMessage());
        }

        try {
            System.out.println("Queue dequeue output " + queue.dequeue());
        } catch (Exception e) {
            System.out.println("Queue error message : " + e.getMessage());
        }
    }
}

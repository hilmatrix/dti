package com.hilmatrix.exercise.day11;

public class Queue<T> extends LinkedList<T> {
    private Node tail = null;

    public void enqueue(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public T dequeue() {
        if (head == null) {
            return null;
        }
        T data = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return data;
    }
}

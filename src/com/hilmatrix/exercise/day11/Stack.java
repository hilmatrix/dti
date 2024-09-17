package com.hilmatrix.exercise.day11;

public class Stack<T> extends LinkedList<T> {
    public void push(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public T pop() {
        if (head == null) {
            return null;
        }
        T data = head.data;
        head = head.next;
        return data;
    }
}

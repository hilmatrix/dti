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

    public T pop() throws NullPointerException {
        if (head == null) {
            throw new NullPointerException("Pop from already empty stack");
        }
        T data = head.data;
        head = head.next;
        return data;
    }

    public T peek() throws NullPointerException {
        if (head == null) {
            throw new NullPointerException("Peek from already empty stack");
        }
        return head.data;
    }
}

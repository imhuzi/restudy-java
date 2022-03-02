package com.uyibai.base.type;

/**
 * 实现一个自己的栈
 *
 * @param <T>
 */
public class MyStack<T> {
    private int size;
    private Node first;
    private Node next;

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    /**
     * 向栈顶push
     *
     * @param item
     */
    public void push(T item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        size++;
    }

    /**
     * 从栈顶 pop
     *
     * @return
     */
    public T pop() {
        T item = first.item;
        first = first.next;
        size--;
        return item;
    }

    private class Node {
        T item;
        Node next;
    }
}

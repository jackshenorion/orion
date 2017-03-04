package com.shenpinyi.microsoft.questionThree;

public class MinStack<T extends Comparable<T>> {
    Object[] items, mins;
    int top, topMin, size;

    public MinStack(int size) {
        this.items = new Object[size];
        this.mins = new Object[size];
        this.top = -1;
        this.topMin = -1;
        this.size = size;
    }

    public T pop() {
        if (top == -1) {
            throw new IllegalStateException("Stack is empty");
        }

        T popItem = (T) items[top--];
        if (isInMinStack(popItem)) {
            topMin --;
        }

        return popItem;
    }

    public void push(T item) {
        if (top == size -1) {
            throw new IllegalStateException("Stack is overflow");
        }
        items[++ top] = item;
        if (isSmaller(item)) {
            mins[++topMin] = item;
        }
    }

    public T min() {
        if (topMin == -1) {
            throw new IllegalStateException("Min stack is empty");
        }

        return (T) mins[topMin];
    }

    private boolean isSmaller(T item) {
        if (topMin == -1) {
            return true;
        }

        return item.compareTo(min()) < 0;
    }

    private boolean isInMinStack(T item) {
        return mins[topMin] == item;
    }
}

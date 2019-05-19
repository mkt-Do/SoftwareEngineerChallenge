package com.github.mktdo.queue.java;

public class EmptyQueue<T> implements Queue<T> {

    public EmptyQueue() {
    }

    public Queue<T> enQueue(T t) {
        return new NonEmptyQueue<T>(t, this);
    }

    public Queue<T> deQueue() {
        return this;
    }

    public T head() {
        return null;
    }

    public boolean isEmpty() {
        return true;
    }
}

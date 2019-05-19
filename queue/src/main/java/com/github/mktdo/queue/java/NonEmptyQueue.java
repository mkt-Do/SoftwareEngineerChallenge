package com.github.mktdo.queue.java;

import java.util.ArrayList;
import java.util.List;

public class NonEmptyQueue<T> implements Queue<T> {

    private T first;

    private Queue<T> rest;

    public NonEmptyQueue(T first, Queue<T> rest) {
        this.first = first;
        this.rest = rest;
    }

    public Queue<T> enQueue(T t) {
        List<T> members = new ArrayList<T>();
        Queue<T> tmpQueue = this;
        while (!tmpQueue.isEmpty()) {
            members.add(0, tmpQueue.head());
            tmpQueue = tmpQueue.deQueue();
        }
        Queue<T> queue = new NonEmptyQueue<T>(t, new EmptyQueue<T>());
        for (T member : members) {
            queue = new NonEmptyQueue<T>(member, queue);
        }
        return queue;
    }

    public Queue<T> deQueue() {
        return this.rest;
    }

    public T head() {
        return this.first;
    }

    public boolean isEmpty() {
        return false;
    }
}

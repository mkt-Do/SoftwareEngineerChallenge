package com.github.mktdo.queue.java;

import java.util.stream.IntStream;
import org.junit.Test;
import org.junit.Assert;

public class QueueTest {

    @Test
    public void AnEmptyQueueReturnTrueByIsEmpty() {
        Queue<Integer> emptyQueue = new EmptyQueue<Integer>();
        Assert.assertTrue(emptyQueue.isEmpty());
    }

    @Test
    public void AnEmptyQueueReturnNullByHead() {
        Queue<Integer> emptyQueue = new EmptyQueue<Integer>();
        Assert.assertNull(emptyQueue.head());
    }

    @Test
    public void AnEmptyQueueReturnThisByDeQueue() {
        Queue<Integer> emptyQueue = new EmptyQueue<Integer>();
        Assert.assertEquals(emptyQueue.deQueue(), emptyQueue);
    }

    @Test
    public void AnEmptyQueueReturnNonEmptyQueueByEnQueueWhenEnqueue1AsValue() {
        Queue<Integer> emptyQueue = new EmptyQueue<Integer>();
        Queue<Integer> queue = emptyQueue.enQueue(1);
        Assert.assertFalse(queue.isEmpty());
    }

    @Test
    public void AnEmptyQueueReturnNullByHeadWhenEnqueue1AsValue() {
        Queue<Integer> emptyQueue = new EmptyQueue<Integer>();
        Queue<Integer> queue = emptyQueue.enQueue(1);
        Assert.assertNull(emptyQueue.head());
    }

    @Test
    public void NonEmptyQueueReturnFalseByIsEmpty() {
        Queue<Integer> emptyQueue = new EmptyQueue<Integer>();
        Queue<Integer> queue = emptyQueue.enQueue(1);
        Assert.assertFalse(queue.isEmpty());
    }

    @Test
    public void NonEmptyQueueReturn1ByHeadWhenEnqueue1AsValue() {
        Queue<Integer> emptyQueue = new EmptyQueue<Integer>();
        Queue<Integer> queue = emptyQueue.enQueue(1);
        Assert.assertEquals(queue.head(), new Integer(1));
    }

    @Test
    public void NonEmptyQueueReturnEmptyQueueByDeQueueWhenEnqueueOnly1AsValue() {
        Queue<Integer> emptyQueue = new EmptyQueue<Integer>();
        Queue<Integer> queue = emptyQueue.enQueue(1);
        Assert.assertEquals(queue.deQueue(), emptyQueue);
    }

    @Test
    public void NonEmptyQueueReturn1ByHeadWhenEnqueue1And2AsValues() {
        Queue<Integer> emptyQueue = new EmptyQueue<Integer>();
        Queue<Integer> queue = emptyQueue.enQueue(1);
        queue = queue.enQueue(2);
        Assert.assertEquals(queue.head(), new Integer(1));
    }

    @Test
    public void NonEmptyQueueReturn2ByHeadWhenEnQueue1And2AsValuesAndThenDeQueue() {
        Queue<Integer> emptyQueue = new EmptyQueue<Integer>();
        Queue<Integer> queue = emptyQueue.enQueue(1);
        queue = queue.enQueue(2);
        Queue<Integer> deQueue = queue.deQueue();
        Assert.assertEquals(deQueue.head(), new Integer(2));
    }

    @Test
    public void NonEmptyQueueReturnFalseByIsEmptyWhenEnqueue1And2AsValuesAndThenDeQueue() {
        Queue<Integer> emptyQueue = new EmptyQueue<Integer>();
        Queue<Integer> queue = emptyQueue.enQueue(1);
        queue = queue.enQueue(2);
        Queue<Integer> deQueue = queue.deQueue();
        Assert.assertFalse(deQueue.isEmpty());
    }

    @Test
    public void NonEmptyQueueReturn51ByHeadWhenEnqueueFrom1To100AsValuesAndThenDeQueue50Times() {
        Queue<Integer> queue = new EmptyQueue<Integer>();
        for (int i = 1; i <= 100; i++) {
            queue = queue.enQueue(i);
        }
        for (int i = 0; i < 50; i++) {
            queue = queue.deQueue();
        }
        Assert.assertEquals(queue.head(), new Integer(51));
    }
}

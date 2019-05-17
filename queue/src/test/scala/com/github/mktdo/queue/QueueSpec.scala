package com.github.mktdo.queue

import org.scalatest._

class QueueSpec extends FlatSpec with Matchers {
  "An Empty Queue" should "return true by isEmpty" in {
    val queue = Queue.empty[Int]
    queue.isEmpty should be (true)
  }
  "An Empty Queue" should "return None by head" in {
    val queue = Queue.empty[Int]
    queue.head should be (None)
  }
  "An Empty Queue" should "return EmptyQueue by deQueue" in {
    val queue = Queue.empty[Int]
    queue.deQueue.isEmpty should be (true)
  }
  "An Empty Queue" should "return NonEmptyQueue by enQueue when enqueue `1` as value" in {
    val queue = Queue.empty[Int]
    val enQueue = queue.enQueue(1)
    enQueue.isEmpty should be (false)
  }
  "An Empty Queue" should "return None by head when enqueue `1` as value" in {
    val queue = Queue.empty[Int]
    val enQueue = queue.enQueue(1)
    queue.head should be (None)
  }
  "Non-Empty Queue" should "return false by isEmpty" in {
    val queue = Queue.empty[Int]
    val enQueue = queue.enQueue(1)
    enQueue.isEmpty should be (false)
  }
  "Non-Empty Queue" should "return Some(1) by head when enqueue `1` as value" in {
    val queue = Queue.empty[Int]
    val enQueue = queue.enQueue(1)
    enQueue.head should be (Some(1))
  }
  "Non-Empty Queue" should "return EmptyQueue by deQueue when enqueue only `1` as value" in {
    val queue = Queue.empty[Int]
    val enQueue = queue.enQueue(1)
    enQueue.deQueue.isEmpty should be (true)
  }
  "Non-Empty Queue" should "return Some(1) by head when enqueue `1` and `2` as values" in {
    val queue = Queue.empty[Int]
    val enQueue = queue.enQueue(1)
    val enQueue2 = enQueue.enQueue(2)
    enQueue2.head should be (Some(1))
  }
  "Non-Empty Queue" should "return Some(2) by head when enqueue `1` and `2` as values and then deQueue" in {
    val queue = Queue.empty[Int]
    val enQueue = queue.enQueue(1)
    val enQueue2 = enQueue.enQueue(2)
    val deQueue = enQueue2.deQueue
    deQueue.head should be (Some(2))
  }
  "Non-Empty Queue" should "return false by isempty when enqueue `1` and `2` as values and then deQueue" in {
    val queue = Queue.empty[Int]
    val enQueue = queue.enQueue(1)
    val enQueue2 = enQueue.enQueue(2)
    val deQueue = enQueue2.deQueue
    deQueue.isEmpty should be (false)
  }
  "Non-Empty Queue" should "return Some(51) by head when enqueue from `1` to `100` as values and then deQueue 50 times" in {
    val queues = (1 to 100).foldLeft(Queue.empty[Int]) { (qs, v) => qs.enQueue(v) }
    val deQueues = (1 to 50).foldLeft(queues) { (qs, _) => qs.deQueue }
    deQueues.head should be (Some(51))
  }
}

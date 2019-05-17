package com.github.mktdo.queue

trait Queue[T] {
  def isEmpty: Boolean
  def enQueue(t: T): Queue[T]
  def deQueue(): Queue[T]
  def head: Option[T]
}

class NonEmptyQueue[T](val first: T, val last: T, val rest: Queue[T]) extends Queue[T] {
  def isEmpty: Boolean = false
  def enQueue(t: T): Queue[T] = new NonEmptyQueue[T](first, t, rest.enQueue(t))
  def deQueue(): Queue[T] = rest.head match {
    case Some(el) => new NonEmptyQueue[T](el, last, rest.deQueue())
    case None => Queue.empty[T]
  }
  def head: Option[T] = Some(first)
}

class EmptyQueue[T] extends Queue[T] {
  def isEmpty: Boolean = true
  def enQueue(t: T): Queue[T] = new NonEmptyQueue[T](t, t, this)
  def deQueue() = Queue.empty[T]
  def head: Option[T] = None
}

object Queue {
  def empty[T]: Queue[T] = new EmptyQueue[T]()
}

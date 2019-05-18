package com.github.mktdo.queue

trait Queue[T] {
  def isEmpty: Boolean
  def enQueue(t: T): Queue[T]
  def deQueue(): Queue[T]
  def head: Option[T]
}

class NonEmptyQueue[T](val first: T, val rest: Queue[T]) extends Queue[T] {
  def isEmpty: Boolean = false
  def enQueue(t: T): Queue[T] = {
    sealed trait TailRec[A] {
      final def run: A = this match {
        case Return(v) => v
        case Suspend(k) => k().run
      }
    }
    case class Return[A](v: A) extends TailRec[A]
    case class Suspend[A](k: () => TailRec[A]) extends TailRec[A]

    def loop(qs: Queue[T], k: Queue[T] => TailRec[Queue[T]]): TailRec[Queue[T]] = qs match {
      case e: EmptyQueue[T] => k(new NonEmptyQueue[T](t, e))
      case NonEmptyQueue(f, r) => loop(r, q => Suspend(() => k(new NonEmptyQueue[T](f, q))))
    }
    val f: Queue[T] => TailRec[Queue[T]] = q => Return(q)
    loop(this, f).run
  }
  def deQueue(): Queue[T] = rest.head match {
    case Some(el) => rest
    case None => Queue.empty[T]
  }
  def head: Option[T] = Some(first)
}

object NonEmptyQueue {
  def unapply[T](queue: Queue[T]): Option[(T, Queue[T])] = queue match {
    case q: NonEmptyQueue[T] => Some((q.first, q.rest))
    case _ => None
  }
}

class EmptyQueue[T] extends Queue[T] {
  def isEmpty: Boolean = true
  def enQueue(t: T): Queue[T] = new NonEmptyQueue[T](t, this)
  def deQueue() = Queue.empty[T]
  def head: Option[T] = None
}

object Queue {
  def empty[T]: Queue[T] = new EmptyQueue[T]()
}

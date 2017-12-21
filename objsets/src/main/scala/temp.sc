import java.util.NoSuchElementException

object temp {
  def singleton[T](elem: T) = new Cons[T](elem, new Nil[T])
                                                  //> singleton: [T](elem: T)Cons[T]
  singleton(1)                                    //> res0: Cons[Int] = Cons@34ce8af7
  def nth[T](n: Int, xs: List[T]) : T = {
  	if (xs.isEmpty || n < 0) throw new IndexOutOfBoundsException
  	if (n == 0) xs.head
  	else nth(n-1, xs.tail)
  }                                               //> nth: [T](n: Int, xs: List[T])T
  
  val list = new Cons(1, new Cons(2, new Cons(3, new Nil)))
                                                  //> list  : Cons[Int] = Cons@b684286
  nth(0, list)                                    //> res1: Int = 1
  
  println("Hello")                                //> Hello
}

trait List[T] {
	def isEmpty : Boolean
	def head : T
	def tail : List[T]
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
	def isEmpty = false
}

class Nil[T] extends List[T] {
	def isEmpty : Boolean = true
	def head : Nothing = throw new NoSuchElementException("Nil.head")
	def tail : Nothing = throw new NoSuchElementException("Nil.head")
}
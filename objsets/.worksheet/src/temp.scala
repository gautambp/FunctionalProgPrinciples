import java.util.NoSuchElementException

object temp {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(114); 
  def singleton[T](elem: T) = new Cons[T](elem, new Nil[T]);System.out.println("""singleton: [T](elem: T)Cons[T]""");$skip(15); val res$0 = 
  singleton(1);System.out.println("""res0: Cons[Int] = """ + $show(res$0));$skip(159); 
  def nth[T](n: Int, xs: List[T]) : T = {
  	if (xs.isEmpty || n < 0) throw new IndexOutOfBoundsException
  	if (n == 0) xs.head
  	else nth(n-1, xs.tail)
  };System.out.println("""nth: [T](n: Int, xs: List[T])T""");$skip(63); 
  
  val list = new Cons(1, new Cons(2, new Cons(3, new Nil)));System.out.println("""list  : Cons[Int] = """ + $show(list ));$skip(15); val res$1 = 
  nth(0, list);System.out.println("""res1: Int = """ + $show(res$1));$skip(22); 
  
  println("Hello")}
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

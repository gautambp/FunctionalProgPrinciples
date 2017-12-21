package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {
      if (r == 0) 1 else if (c == 0) 1 else if (c == r) 1 else pascal(c, r-1) + pascal(c-1, r-1)
    }
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      def countParan(chars: List[Char], openParanBalance: Int): Int = {
        if (chars.isEmpty) {
          0 
        } else if (chars.head == '(') {
          1 + countParan(chars.tail, openParanBalance+1) 
        } else if (chars.head == ')') {
          if (openParanBalance > 0) countParan(chars.tail, openParanBalance-1)-1 else -1
        } else {
          countParan(chars.tail, openParanBalance)
        }
      }
      countParan(chars, 0) == 0
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      def changeCount(money: Int, coins: List[Int]): Int = {
        if (money < 0 || coins.isEmpty) 0
        else if (money == 0) 1
        else changeCount(money, coins.tail) + changeCount(money-coins.head, coins)
      }
      changeCount(money, coins.sortWith(_ > _))
    }
  }

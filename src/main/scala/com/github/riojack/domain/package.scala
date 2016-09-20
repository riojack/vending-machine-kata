package com.github.riojack

package object domain {
  val Nickel = Coin(5.0, 21.21)
  val Dime = Coin(2.268, 17.91)
  val Quarter = Coin(5.670, 24.26)
  val Penny = Coin(2.5, 19.05)

  val Cola = Product("Cola", 100)
  val Chips = Product("Chips", 50)
  val Candy = Product("Candy", 65)
}

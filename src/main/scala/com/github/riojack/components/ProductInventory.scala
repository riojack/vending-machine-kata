package com.github.riojack.components

import com.github.riojack.domain._

case class ProductInventory(cola: Int = 0, chips: Int = 0, candy: Int = 0) {
  def add(product: Product): ProductInventory = product match {
    case Chips => copy(chips = chips + 1)
    case Candy => copy(candy = candy + 1)
    case _ => copy(cola = cola + 1)
  }
}

object ProductInventory {
  def apply() = new ProductInventory()
}
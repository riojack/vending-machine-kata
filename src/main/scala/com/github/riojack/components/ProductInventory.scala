package com.github.riojack.components

case class ProductInventory(cola: Int = 0, chips: Int = 0, candy: Int = 0) {
  def add(product: Product): ProductInventory = ???
}

object ProductInventory {
  def apply() = new ProductInventory()
}
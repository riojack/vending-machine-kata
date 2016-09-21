package com.github.riojack.components

case class ProductInventory(cola: Int = 0, chips: Int = 0, candy: Int = 0) {
  def add(product: Product) = ProductInventory(cola = 1)
}

object ProductInventory {
  def apply() = new ProductInventory()
}
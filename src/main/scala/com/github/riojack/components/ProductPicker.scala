package com.github.riojack.components

import com.github.riojack.domain._

class ProductPicker(startingInventory: ProductInventory) {
  private lazy val dispenser = ProductDispenser

  def giveMe(productName: String) = dispenser.dispense(productName)
}

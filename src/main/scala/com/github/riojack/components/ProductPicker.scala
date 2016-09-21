package com.github.riojack.components

import com.github.riojack.domain._

class ProductPicker(startingInventory: ProductInventory) {
  private lazy val dispenser = ProductDispenser
  private var inventory = startingInventory

  def giveMe(productName: String) = dispenser.dispense(productName) match {
    case Some(Cola) if inventory.cola > 0 => {
      inventory = inventory.remove(Cola)
      Some(Cola)
    }
    case _ => None
  }
}

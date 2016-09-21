package com.github.riojack.components

import com.github.riojack.domain._
import org.scalatest._

import scala.language.postfixOps

class ProductInventoryTest extends FlatSpec with Matchers {
  "A Product Inventory" should "have zero inventory when first created" in {
    val inventory = ProductInventory()

    inventory should equal(new ProductInventory(0, 0, 0))
  }

  it should "accept a Cola and increment its cola inventory count by one" in {
    val nextInventory = ProductInventory().add(Cola)

    nextInventory should equal(new ProductInventory(cola = 1))
  }
}
package com.github.riojack.components

import org.scalatest._

import scala.language.postfixOps

class ProductInventoryTest extends FlatSpec with Matchers {
  "A Product Inventory" should "have zero inventory when first created" in {
    val inventory = ProductInventory()

    inventory should equal(new ProductInventory(0, 0, 0))
  }
}
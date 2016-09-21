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

  it should "accept Chips and increment its chips inventory count by one" in {
    val nextInventory = ProductInventory().add(Chips)

    nextInventory should equal(new ProductInventory(chips = 1))
  }

  it should "accept Candy and increment its candy inventory count by one" in {
    val nextInventory = ProductInventory().add(Candy)

    nextInventory should equal(new ProductInventory(candy = 1))
  }
}
package com.github.riojack.components

import com.github.riojack.domain._
import org.scalatest._

import scala.language.postfixOps
import scala.util.Random._

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

  it should "accept various amounts of Cola, Candy, and Chip products and increment each count appropriately" in {
    val (chipsCount, colaCount, candyCount) = (nextInt(10), nextInt(10), nextInt(10))

    val loadedInventory = loadInventory(chipsCount, colaCount, candyCount)

    loadedInventory should equal(new ProductInventory(cola = colaCount, chips = chipsCount, candy = candyCount))
  }

  it should "reject adding unknown products by leaving inventory counts unchanged" in {
    val expectedInventory = ProductInventory().add(Candy).add(Candy).add(Candy).add(Cola).add(Chips)
    val actualInventory = expectedInventory.add(Product(alphanumeric.take(10).mkString, nextInt(200)))

    actualInventory should equal(expectedInventory)
  }

  it should "remove Cola and decrement its cola inventory count by one" in {
    val nextInventory = ProductInventory().add(Cola).add(Cola).add(Cola).remove(Cola)

    nextInventory should equal(new ProductInventory(cola = 2))
  }

  it should "remove Chips and decrement its chips inventory count by one" in {
    val nextInventory = ProductInventory().add(Chips).add(Chips).add(Chips).remove(Chips)

    nextInventory should equal(new ProductInventory(chips = 2))
  }

  it should "remove Candy and decrement its candy inventory count by one" in {
    val nextInventory = ProductInventory().add(Candy).add(Candy).add(Candy).remove(Candy)

    nextInventory should equal(new ProductInventory(candy = 2))
  }

  it should "retain other inventory counts while removing Cola" in {
    val (chipsCount, colaCount, candyCount) = (1 + nextInt(9), 1 + nextInt(9), 1 + nextInt(9))

    val loadedInventory = loadInventory(chipsCount, colaCount, candyCount)
    val fewerColasInventory = loadedInventory.remove(Cola)

    fewerColasInventory should equal(new ProductInventory(chips = chipsCount, cola = colaCount - 1, candy = candyCount))
  }

  private def loadInventory(chips: Int, cola: Int, candy: Int) = {
    val withChips = (1 to chips).foldLeft(new ProductInventory()) {
      (inventory: ProductInventory, _) =>
        inventory.add(Chips)
    }

    val withCola = (1 to cola).foldLeft(withChips) {
      (inventory: ProductInventory, _) =>
        inventory.add(Cola)
    }

    (1 to candy).foldLeft(withCola) {
      (inventory: ProductInventory, _) =>
        inventory.add(Candy)
    }
  }
}
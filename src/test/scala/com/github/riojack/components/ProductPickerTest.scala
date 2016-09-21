package com.github.riojack.components

import com.github.riojack.domain._
import org.scalatest._

import scala.language.postfixOps
import scala.util.Random._

class ProductPickerTest extends FlatSpec with Matchers {
  "A Product Picker" should "return nothing if there is no inventory regardless of the product" in {
    val inventory = ProductInventory()
    val picker = new ProductPicker(inventory)

    val productName = alphanumeric.take(10).mkString
    val product = picker.giveMe(productName)

    product should be(None)
  }

  it should "return nothing if there is inventory but the product is not recognized" in {
    val inventory = ProductInventory(1, 1, 1)
    val picker = new ProductPicker(inventory)

    val productName = alphanumeric.take(10).mkString
    val product = picker.giveMe(productName)

    product should be(None)
  }

  it should "return cola if the inventory has one or more colas" in {
    val inventory = ProductInventory(cola = 1 + nextInt(10))
    val picker = new ProductPicker(inventory)

    val product = picker.giveMe("cola")

    product should be(Some(Cola))
  }

  it should "return nothing if there all the cola is dispensed after several requests" in {
    val inventory = ProductInventory(cola = 3)
    val picker = new ProductPicker(inventory)

    picker.giveMe("cola")
    picker.giveMe("cola")
    picker.giveMe("cola")
    val product = picker.giveMe("cola")

    product should be(None)
  }

  it should "return chips if the inventory has one or more chips" in {
    val inventory = ProductInventory(chips = 1 + nextInt(10))
    val picker = new ProductPicker(inventory)

    val product = picker.giveMe("chips")

    product should be(Some(Chips))
  }

  it should "return nothing if there all the chips are dispensed after several requests" in {
    val inventory = ProductInventory(chips = 3)
    val picker = new ProductPicker(inventory)

    picker.giveMe("chips")
    picker.giveMe("chips")
    picker.giveMe("chips")
    val product = picker.giveMe("chips")

    product should be(None)
  }

  it should "return candy if the inventory has one or more candies" in {
    val inventory = ProductInventory(candy = 1 + nextInt(10))
    val picker = new ProductPicker(inventory)

    val product = picker.giveMe("candy")

    product should be(Some(Candy))
  }

}
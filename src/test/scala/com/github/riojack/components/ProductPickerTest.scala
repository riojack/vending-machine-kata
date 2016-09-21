package com.github.riojack.components

import org.scalatest._

import scala.language.postfixOps
import scala.util.Random._
import com.github.riojack.domain._

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

}
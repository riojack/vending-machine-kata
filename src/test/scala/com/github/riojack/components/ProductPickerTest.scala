package com.github.riojack.components

import org.scalatest._

import scala.language.postfixOps
import scala.util.Random._

class ProductPickerTest extends FlatSpec with Matchers with BeforeAndAfter {
  "A Product Picker" should "return nothing if there is no inventory regardless of the product" in {
    implicit val inventory = ProductInventory()
    val picker = new ProductPicker()

    val productName = alphanumeric.take(10).mkString
    val product = picker.giveMe(productName)

    product should be(None)
  }

  it should "return nothing if there is inventory but the product is not recognized" in {
    implicit val inventory = ProductInventory(1, 1, 1)
    val picker = new ProductPicker()

    val productName = alphanumeric.take(10).mkString
    val product = picker.giveMe(productName)

    product should be(None)
  }
}
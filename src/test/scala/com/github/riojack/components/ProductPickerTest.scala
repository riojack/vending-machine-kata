package com.github.riojack.components

import org.scalatest._

import scala.language.postfixOps
import scala.util.Random._

class ProductPickerTest extends FlatSpec with Matchers with BeforeAndAfter {
  "A Product Picker" should "should return nothing if there is no inventory" in {
    implicit val inventory = ProductInventory()
    val picker = new ProductPicker()

    val productName = alphanumeric.take(10).mkString
    val product = picker.giveMe(productName)

    product should be(None)
  }
}
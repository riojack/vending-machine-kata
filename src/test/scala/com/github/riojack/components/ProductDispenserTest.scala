package com.github.riojack.components

import com.github.riojack.domain._
import org.scalatest._

import scala.language.postfixOps
import scala.util.Random

class ProductDispenserTest extends FlatSpec with Matchers {
  "A Product Dispenser" should """dispense cola when "cola" is requested""" in {
    val productName = "cola"

    ProductDispenser.dispense(productName) should equal(Some(Cola))
  }

  it should """dispense chips when "chips" is requested""" in {
    val productName = "chips"

    ProductDispenser.dispense(productName) should equal(Some(Chips))
  }

  it should """dispense candy when "candy" is requested""" in {
    val productName = "candy"

    ProductDispenser.dispense(productName) should equal(Some(Candy))
  }

  it should """dispense nothing when any product other than "cola", "chips", or "candy" is requested""" in {
    val productName = Random.alphanumeric.take(10).mkString

    ProductDispenser.dispense(productName) should be(None)
  }
}
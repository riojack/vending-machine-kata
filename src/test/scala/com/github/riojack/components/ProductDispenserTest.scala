package com.github.riojack.components

import com.github.riojack.domain._
import org.scalatest._

import scala.language.postfixOps
import scala.util.Random._

class ProductDispenserTest extends FlatSpec with Matchers {
  "A Product Dispenser" should """dispense cola when "cola" is selected""" in {
    val productName = "cola"

    ProductDispenser.dispense(productName) should equal(Some(Cola))
  }

  it should """dispense chips when "chips" is selected""" in {
    val productName = "chips"

    ProductDispenser.dispense(productName) should equal(Some(Chips))
  }

  it should """dispense candy when "candy" is selected""" in {
    val productName = "candy"

    ProductDispenser.dispense(productName) should equal(Some(Candy))
  }
}
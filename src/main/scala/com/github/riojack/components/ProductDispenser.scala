package com.github.riojack.components

import com.github.riojack.domain._

object ProductDispenser {
  def dispense(productName: String) = productName match {
    case "chips" => Chips
    case "candy" => Candy
    case _ => Cola
  }
}

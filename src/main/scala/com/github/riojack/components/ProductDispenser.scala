package com.github.riojack.components

import com.github.riojack.domain._

object ProductDispenser {
  def dispense(productName: String) = productName match {
    case "chips" => Some(Chips)
    case "candy" => Some(Candy)
    case _ => Some(Cola)
  }
}

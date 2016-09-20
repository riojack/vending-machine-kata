package com.github.riojack.components

import com.github.riojack.domain.Coin

case class CoinReceiver(pennies: Int = 0, nickels: Int = 0, dimes: Int = 0, quarters: Int = 0) {
  def putCoin(coin: Coin) = coin match {
    case Coin(5.0, 21.21) => copy(nickels = nickels + 1)
    case Coin(2.268, 17.91) => copy(dimes = dimes + 1)
    case Coin(5.670, 24.26) => copy(quarters = quarters + 1)
    case Coin(2.5, 19.05) => copy()
    case _ => new CoinReceiver()
  }
}

object CoinReceiver {
  def apply() = new CoinReceiver()
}

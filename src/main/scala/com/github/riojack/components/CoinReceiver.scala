package com.github.riojack.components

import com.github.riojack.domain.Coin

case class CoinReceiver(pennies: Int = 0, nickels: Int = 0, dimes: Int = 0, quarters: Int = 0) {
  def putCoin(coin: Coin) = coin match {
    case Coin(0, 0) => new CoinReceiver()
    case _ => new CoinReceiver(nickels = 1)
  }
}

object CoinReceiver {
  def apply() = new CoinReceiver()
}

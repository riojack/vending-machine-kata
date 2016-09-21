package com.github.riojack.components

import com.github.riojack.domain.Coin
import com.github.riojack.domain._

case class CoinReceiver(pennies: Int = 0, nickels: Int = 0, dimes: Int = 0, quarters: Int = 0) {
  def returnCoins = {
    val quarterCoins = Seq.fill(quarters) { Quarter }
    val dimeCoins = Seq.fill(dimes) { Dime }
    val nickelCoins = Seq.fill(nickels) { Nickel }

    quarterCoins ++ dimeCoins ++ nickelCoins
  }

  def putCoin(coin: Coin) = coin match {
    case Coin(5.0, 21.21) => copy(nickels = nickels + 1)
    case Coin(2.268, 17.91) => copy(dimes = dimes + 1)
    case Coin(5.670, 24.26) => copy(quarters = quarters + 1)
    case _ => copy()
  }
}

object CoinReceiver {
  def apply() = new CoinReceiver()
}

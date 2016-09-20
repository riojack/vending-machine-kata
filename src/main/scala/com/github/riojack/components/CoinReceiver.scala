package com.github.riojack.components

import com.github.riojack.domain.Coin

case class CoinReceiver(coins: Seq[Coin] = Seq()) {
  def putCoin(coin: Coin):CoinReceiver = new CoinReceiver()
}

object CoinReceiver {
  def apply() = new CoinReceiver()
}

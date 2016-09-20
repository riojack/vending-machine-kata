package com.github.riojack.components

import com.github.riojack.domain.Coin
import org.scalatest._

class CoinReceiverTest extends FlatSpec with Matchers {
  "A Coin Receiver" should "reject a weightless, diameterless coin" in {
    val coinReceiver = CoinReceiver()
    val coin = Coin()

    val nextCoinReceiver = coinReceiver.putCoin(coin)

    nextCoinReceiver.coins.size should be (0)
  }
}
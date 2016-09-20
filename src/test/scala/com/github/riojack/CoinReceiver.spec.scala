package com.github.riojack.components

import com.github.riojack.domain.Coin
import org.scalatest._

class CoinReceiverTest extends FlatSpec with Matchers {
  "A Coin Receiver" should "reject a weightless, diameterless coin" in {
    val coinReceiver = CoinReceiver()
    val coin = Coin()

    val nextCoinReceiver = coinReceiver.putCoin(coin)

    nextCoinReceiver should equal(CoinReceiver())
  }

  "A Coin Receiver" should "accept a coin with a weight of 5.0 and a diameter of 21.21 (nickel)" in {
    val coinReceiver = CoinReceiver()
    val coin = Coin(5.0, 21.21)

    val nextCoinReceiver = coinReceiver.putCoin(coin)

    nextCoinReceiver should equal(CoinReceiver(nickels = 1))
  }

  "A Coin Receiver" should "accept a coin with a weight of 2.268 and a diameter of 17.91" in {
    val coinReceiver = CoinReceiver()
    val coin = Coin(2.268, 17.91)

    val nextCoinReceiver = coinReceiver.putCoin(coin)

    nextCoinReceiver should equal(CoinReceiver(dimes = 1))
  }

  "A Coin Receiver" should "accept a coin with a weight of 5.670 and a diameter of 24.26" in {
    val coinReceiver = CoinReceiver()
    val coin = Coin(5.670, 24.26)

    val nextCoinReceiver = coinReceiver.putCoin(coin)

    nextCoinReceiver should equal(CoinReceiver(quarters = 1))
  }
}
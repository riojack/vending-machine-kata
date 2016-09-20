package com.github.riojack.components

import com.github.riojack.domain._
import org.scalatest._

class CoinReceiverTest extends FlatSpec with Matchers {
  "A Coin Receiver" should "reject a coin with zero weight and zero diameter" in {
    val coinReceiver = CoinReceiver()
    val coin = Coin()

    val nextCoinReceiver = coinReceiver.putCoin(coin)

    nextCoinReceiver should equal(CoinReceiver())
  }

  "A Coin Receiver" should "accept a coin with a weight of 5.0 and a diameter of 21.21 (nickel)" in {
    val coinReceiver = CoinReceiver()
    val coin = Nickel

    val nextCoinReceiver = coinReceiver.putCoin(coin)

    nextCoinReceiver should equal(CoinReceiver(nickels = 1))
  }

  "A Coin Receiver" should "accept a coin with a weight of 2.268 and a diameter of 17.91 (dime)" in {
    val coinReceiver = CoinReceiver()
    val coin = Dime

    val nextCoinReceiver = coinReceiver.putCoin(coin)

    nextCoinReceiver should equal(CoinReceiver(dimes = 1))
  }

  "A Coin Receiver" should "accept a coin with a weight of 5.670 and a diameter of 24.26 (quarter)" in {
    val coinReceiver = CoinReceiver()
    val coin = Quarter

    val nextCoinReceiver = coinReceiver.putCoin(coin)

    nextCoinReceiver should equal(CoinReceiver(quarters = 1))
  }

  "A Coin Receiver" should "reject a coin with a weight of 2.500 and a diameter of 19.05 (penny)" in {
    val coinReceiver = CoinReceiver()
    val coin = Penny

    val nextCoinReceiver = coinReceiver.putCoin(coin)

    nextCoinReceiver should equal(CoinReceiver())
  }
}
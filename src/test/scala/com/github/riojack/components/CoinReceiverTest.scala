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

  it should "accept a coin with a weight of 5.0 and a diameter of 21.21 (nickel)" in {
    val coinReceiver = CoinReceiver()
    val coin = Nickel

    val nextCoinReceiver = coinReceiver.putCoin(coin)

    nextCoinReceiver should equal(CoinReceiver(nickels = 1))
  }

  it should "accept a coin with a weight of 2.268 and a diameter of 17.91 (dime)" in {
    val coinReceiver = CoinReceiver()
    val coin = Dime

    val nextCoinReceiver = coinReceiver.putCoin(coin)

    nextCoinReceiver should equal(CoinReceiver(dimes = 1))
  }

  it should "accept a coin with a weight of 5.670 and a diameter of 24.26 (quarter)" in {
    val coinReceiver = CoinReceiver()
    val coin = Quarter

    val nextCoinReceiver = coinReceiver.putCoin(coin)

    nextCoinReceiver should equal(CoinReceiver(quarters = 1))
  }

  it should "reject a coin with a weight of 2.500 and a diameter of 19.05 (penny)" in {
    val coinReceiver = CoinReceiver()
    val coin = Penny

    val nextCoinReceiver = coinReceiver.putCoin(coin)

    nextCoinReceiver should equal(CoinReceiver())
  }

  it should "retain prior nickel, dime, and quarter counts when another nickel, dime, or quarter is added" in {
    val nextCoinReceiver = CoinReceiver() putCoin Dime putCoin Dime putCoin Quarter putCoin Nickel

    nextCoinReceiver should equal(CoinReceiver(pennies = 0, nickels = 1, dimes = 2, quarters = 1))
  }

  it should "retain prior nickel, dime, and quarter counts when a penny is rejected" in {
    val nextCoinReceiver = CoinReceiver() putCoin Dime putCoin Dime putCoin Quarter putCoin Nickel putCoin Penny

    nextCoinReceiver should equal(CoinReceiver(pennies = 0, nickels = 1, dimes = 2, quarters = 1))
  }

  it should "retain prior nickel, dime, and quarter counts when a coin with zero weight and zero diameter is rejected" in {
    val nextCoinReceiver = CoinReceiver() putCoin Dime putCoin Dime putCoin Quarter putCoin Nickel putCoin Coin()

    nextCoinReceiver should equal(CoinReceiver(pennies = 0, nickels = 1, dimes = 2, quarters = 1))
  }
}
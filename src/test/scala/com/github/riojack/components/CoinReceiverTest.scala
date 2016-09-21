package com.github.riojack.components

import com.github.riojack.domain._
import org.scalatest._

import scala.collection.immutable.IndexedSeq
import scala.util.Random._

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

  it should "return zero coins of zero coins were placed in it" in {
    val coins = CoinReceiver().returnCoins

    coins should equal(Seq())
  }

  it should "return one dime if one dime was placed in it" in {
    val coins = CoinReceiver() putCoin Dime returnCoins

    coins should equal(Seq(Dime))
  }

  it should "return one nickel if one nickel was placed in it" in {
    val coins = CoinReceiver() putCoin Nickel returnCoins

    coins should equal(Seq(Nickel))
  }

  it should "return one quarter if one quarter was placed in it" in {
    val coins = CoinReceiver() putCoin Quarter returnCoins

    coins should equal(Seq(Quarter))
  }

  it should "return the expected amount of quarters, dimes, and nickels that were placed in it" in {
    val quarters = for (q <- 1 to nextInt(10)) yield Quarter
    val dimes = for (d <- 1 to nextInt(10)) yield Dime
    val nickels = for (d <- 1 to nextInt(10)) yield Nickel

    val expectedCoins = quarters ++ dimes ++ nickels

    val loadedReceiver = loadReceiver(expectedCoins)

    val coins = loadedReceiver returnCoins

    coins should equal(expectedCoins)
  }

  private def loadReceiver(coins: Seq[Coin]) = {
    coins.foldLeft(CoinReceiver()) {
      (receiver, coin) => receiver.putCoin(coin)
    }
  }
}
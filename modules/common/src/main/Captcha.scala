package lila.common

// import scalaz.NonEmptyList
import scalaz._
import Scalaz._

case class Captcha(
    gameId: String,
    fen: String,
    white: Boolean,
    solutions: Captcha.Solutions,
    moves: Map[String, String]
) {

  def valid(solution: String) = solutions.toList contains solution
}

object Captcha {

  type Solutions = NonEmptyList[String]

  val default = Captcha(
    gameId = "00000000",
    fen = "1k3b1r/r5pp/pNQppq2/2p5/4P3/P3B3/1P3PPP/n4RK1",
    white = true,
    solutions = NonEmptyList("c6 c8"),
    moves = Map("c6" -> "c8")
  )
}

package simulations

import config.Configuration._
import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import io.gatling.http.Predef._
import scenarios.TestAPIScenario

import scala.concurrent.duration.DurationInt
import scala.language.postfixOps

class TestPostAPISimulation extends Simulation {

  val httpConf = http.baseUrl(baseUrl)

  private val testPost = TestAPIScenario.testAPIPost
    .inject(
      constantUsersPerSec(10) during(30 seconds)
    ).protocols(httpConf)

  setUp(testPost)
}
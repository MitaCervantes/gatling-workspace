package simulations;

import config.Configuration._
import io.gatling.core.scenario.Simulation
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scenarios.TestAPIScenario

import scala.concurrent.duration.DurationInt
import scala.language.postfixOps


class TestGetAPISimulation extends Simulation {

  val httpConf = http.baseUrl(baseUrl)

  private val testGet = TestAPIScenario.testAPIGet
    .inject(
      rampUsersPerSec(1) to 40 during (30 seconds),
      constantUsersPerSec(40) during (40 seconds),
      rampUsersPerSec(40) to 1 during (30 seconds)
    ).protocols(httpConf)

  setUp(testGet)
}
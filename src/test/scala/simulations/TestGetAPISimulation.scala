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
      rampUsersPerSec(1) to 20 during (60 seconds)
    ).protocols(httpConf)

  setUp(testGet)
}
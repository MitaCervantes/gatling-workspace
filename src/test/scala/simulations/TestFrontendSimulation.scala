package simulations

import config.Configuration._
import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import io.gatling.http.Predef._
import scenarios.TestFrontendScenario

import scala.concurrent.duration.DurationInt
import scala.language.postfixOps


class TestFrontendSimulation extends Simulation {

  val httpConf = http.baseUrl(baseUrlFrontend)

  private val testFront = TestFrontendScenario.testFrontend
    .inject(
      constantUsersPerSec(2) during (120 seconds)
    ).protocols(httpConf)

  setUp(testFront)
}
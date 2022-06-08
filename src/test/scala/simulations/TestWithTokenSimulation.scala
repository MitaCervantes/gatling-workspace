package simulations

import config.Configuration._
import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import io.gatling.http.Predef._
import scenarios.TestAPIScenario

import scala.concurrent.duration.DurationInt
import scala.language.postfixOps


class TestWithTokenSimulation extends Simulation {

  val httpConf = http.baseUrl(baseUrl)

  private val token = TestAPIScenario.getAuthToken
    .inject(
      atOnceUsers(1)
    ).protocols(httpConf)

  private val peakLoadTest = TestAPIScenario.testAPIGetWithtoken
    .inject(
      rampUsersPerSec(1) to 35 during (20 seconds), //aumento durante 1 minuto la cant de request hasta llegar a 2100
      constantUsersPerSec(35) during (20 seconds), //ya en 2100, voy ejecutando 35 requests por segundo
      rampUsersPerSec(35) to (1) during(20 seconds) //baja la curva a 1 user
    ).protocols(httpConf)

  setUp(
    token.andThen(
      peakLoadTest
    )
  )
}
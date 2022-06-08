package scenarios

import io.gatling.core.Predef._
import requests.TestFrontendRequest

object TestFrontendScenario {

  val testFrontend = scenario("TEST FRONTEND SCENARIO" )
    .exec(TestFrontendRequest.testFrontend)
}
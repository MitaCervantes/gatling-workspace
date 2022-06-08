package scenarios

import io.gatling.core.Predef._
import requests.AuthRequest.authToken
import requests.{AuthRequest, TestAPIRequest}

object TestAPIScenario {

  val getAuthToken = scenario("GET Token")
    .exec(AuthRequest.getAccesToken)

  val testAPIGet = scenario("TEST API SCENARIO GET" )
    .exec(TestAPIRequest.testGetAPI)

  val testAPIPost = scenario("TEST API SCENARIO GET" )
    .exec(TestAPIRequest.testPostAPI)

  val testAPIGetWithtoken = scenario("TEST API SCENARIO GET WITH TOKEN" )
    .exec(session => {session.set("token", authToken)})
    .exec(TestAPIRequest.testGetAPI)
}
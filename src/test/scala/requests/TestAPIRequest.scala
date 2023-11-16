package requests

import config.Configuration._
import io.gatling.core.Predef._
import io.gatling.http.Predef._

object TestAPIRequest {

  private val headers = Map(
    "Accept" -> "application/json",
    "Content-Type" -> "application/json"
  )

  private val headersToken = Map(
    "Authorization" -> "Bearer ${token}"
  )

  val testGetAPI = exec(http("request get")
      .get(urlGetAPI)
      .headers(headers)
      .check(status.is(200))
    )

  val testPostAPI = exec(http("request post")
    .post(urlPostAPI)
    .headers(headers)
    .body( StringBody(
      """{
          "name": "mauricio",
          "job": "employee"
          }"""
    )).asJson
    .check(status.is(201))
    .check(jsonPath("$.name").is("mauricio"))
    .check(jsonPath("$.job").is("employee"))
  )

  val getJson = exec(http("GET Test Json")
    .post(urlPostAPI)
    .headers(headers)
    .body(RawFileBody("requestJson.json")).asJson
    .check(status.is(200))
  )

}

package requests

import config.Configuration.token
import io.gatling.core.Predef._
import io.gatling.http.Predef._

object AuthRequest {

  var authToken = ""

  val getAccesToken = exec(http("Get access token")
    .post(token)
    .headers(Map("Content-Type" -> "application/x-www-form-urlencoded"))
    .formParamMap(Map("client_id" -> "",
      "client_secret" -> "",
      "grant_type" -> "client_credentials",
      "scope" -> "openid"))
    .check(status.is(200))
    .check(jsonPath("$.access_token").saveAs("token")))

    .exec(session => {
      authToken = session("token").as[String].trim
      session}
    )
}
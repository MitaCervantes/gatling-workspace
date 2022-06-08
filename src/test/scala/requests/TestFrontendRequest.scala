package requests

import config.Configuration._
import io.gatling.core.Predef._
import io.gatling.http.Predef._

object TestFrontendRequest {

  private val headersFrontend = Map(
    "Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
    "Connection" -> "keep-alive",
    "Content-Type" -> "text/html"
  )

  val testFrontend = exec(http("front")
    .post("")
    .headers(headersFrontend)
    .formParam("Educación", "Escuela Test")
    .formParam("Institución", "Test Intitución")
    .formParam("EMPRESA", "Crowdar")
    .formParam("Título personalizado", "Programador"))

}

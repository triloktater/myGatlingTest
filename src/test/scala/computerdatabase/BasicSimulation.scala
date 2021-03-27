package computerdatabase
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class BasicSimulation extends Simulation {

  val httpProtocol = http.baseUrl("https://jsonplaceholder.typicode.com/posts")

  val scn =
      scenario("Assignement1") // A scenario is a chain of requests and pauses
        .exec(
          http("request_1")
            .get("/")
            .check(status.is(200)) // Note that Gatling has recorder real time pauses
        )

  setUp(scn.inject(
    constantConcurrentUsers(3) during(60 seconds))
    .throttle(reachRps(1) in (0 second),holdFor(1 minute))
    .protocols(httpProtocol))
}
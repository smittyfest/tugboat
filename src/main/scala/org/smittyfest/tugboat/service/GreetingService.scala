package org.smittyfest.tugboat.service

import akka.actor.Actor
import spray.http.MediaTypes.`text/html`
import spray.routing.HttpService

/**
  * @author smittyfest
  * @since 4/2/16
  */
class GreetingServiceActor extends Actor with GreetingService {
  def actorRefFactory = context
  def receive = runRoute(greetingRoute)
}
trait GreetingService extends HttpService {
  val greetingRoute =
    path("") {
      get {
        respondWithMediaType(`text/html`) { // XML is marshalled to `text/xml` by default, so we simply override here
          complete {
            <html>
              <body>
                <h1>Say hello to <i>spray-routing</i> on <i>spray-can</i>!</h1>
              </body>
            </html>
          }
        }
      }
    }
}

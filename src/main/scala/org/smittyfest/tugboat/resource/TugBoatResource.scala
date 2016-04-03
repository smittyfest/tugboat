package org.smittyfest.tugboat.resource

import akka.actor.{ActorSystem, Props}
import akka.io.IO
import akka.pattern.ask
import akka.util.Timeout
import org.smittyfest.tugboat.service.GreetingServiceActor
import spray.can.Http
import scala.concurrent.duration._

/**
  * @author smittyfest
  * @since 4/2/16
  */
object TugBoatResource extends App {
  implicit val actorSystem = ActorSystem("on-spray-can")
  val greetingActor = actorSystem.actorOf(Props[GreetingServiceActor], "greeting-service")
  implicit val timeout = Timeout(5.seconds)
  IO(Http) ? Http.Bind(greetingActor, interface = "localhost", port = 4567)
}

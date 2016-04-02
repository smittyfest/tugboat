package org.smittyfest.tugboat.resource

import akka.actor.ActorSystem

/**
  * @author smittyfest
  * @since 4/2/16
  */
object TugBoatResource extends App {
  implicit val actorSystem = ActorSystem("on-spray-can")
}

name := "tugboat"

version := "1.0"

scalaVersion := "2.11.8"

resolvers += "spray repo" at "http://repo.spray.io"

libraryDependencies ++= Seq("io.spray" %% "spray-can" % "1.3.3")

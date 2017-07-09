name := "url-shortener-scala"
organization := "com.hastybox"

version := "1.0"

scalaVersion := "2.12.1"

lazy val versions = new {
  val finatra = "2.11.0"
  val logback = "1.2.3"
}

libraryDependencies ++= Seq(
  "com.twitter" %% "finatra-http" % versions.finatra,
  "ch.qos.logback" % "logback-classic" % versions.logback
)
        
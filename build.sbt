name := "url-shortener-scala"
organization := "com.hastybox"

version := "1.0"

scalaVersion := "2.12.1"

lazy val versions = new {
  val finatra = "2.11.0"
}

libraryDependencies ++= Seq(
  "com.twitter" %% "finatra-http" % versions.finatra
)
        
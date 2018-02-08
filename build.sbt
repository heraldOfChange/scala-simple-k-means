name := "simpleKMeans"

version := "0.1"

scalaVersion := "2.11.8"

val scalaTestVersion = "3.0.4"

libraryDependencies ++=Seq(
  "org.scalatest" %% "scalatest" % scalaTestVersion % Test
)
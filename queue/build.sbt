scalaVersion := "2.12.8"

ensimeScalaVersion in ThisBuild := "2.12.8"

libraryDependencies ++= Seq(
  "com.novocode" % "junit-interface" % "0.10" % "test",
  "org.scalactic" %% "scalactic" % "3.0.5",
  "org.scalatest" %% "scalatest" % "3.0.5" % "test"
)

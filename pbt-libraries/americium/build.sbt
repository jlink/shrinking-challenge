lazy val scala2_13_Version = "2.13.8"
lazy val jUnitVersion = "5.7.0"
lazy val javaVersion = "1.8"
lazy val settings = Seq(
  name := "americium",
  javacOptions ++= Seq("-source", javaVersion, "-target", javaVersion),
  libraryDependencies += "com.sageserpent" %% "americium" % "1.8.2",
  libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.9" % Test,
  libraryDependencies += "org.assertj" % "assertj-core" % "3.19.0",
  libraryDependencies += "net.aichler" % "jupiter-interface" % JupiterKeys.jupiterVersion.value % Test,
  libraryDependencies ++= Seq(
    "org.junit.platform" % "junit-platform-runner" % "1.8.2" % Test,
    "org.junit.jupiter" % "junit-jupiter-engine" % "5.8.2" % Test
  ),
  libraryDependencies += "org.hamcrest" % "hamcrest" % "2.2" % Test
)
lazy val americiumShrinkageChallenges =
  (project in file(".")).settings(settings: _*)

ThisBuild / scalaVersion := scala2_13_Version

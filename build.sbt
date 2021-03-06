name := "lift-examples"

version := "1.0-snapshot"

organization := "com.github.dolphineor"

scalaVersion := "2.11.7"

javacOptions ++= Seq(
  "-source", "1.8",
  "-target", "1.8",
  "-Xlint:unchecked"
)

scalacOptions ++= Seq(
  "-encoding", "UTF-8",
  "-unchecked"
)

resolvers ++= Seq(
  Resolver.mavenLocal,
  "maven central repository" at "https://repo1.maven.org/maven2/",
  "typesafe repository" at "https://repo.typesafe.com/typesafe/releases/",
  "sonatype repository" at "https://oss.sonatype.org/content/repositories/releases/"
)

libraryDependencies ++= {
  val liftVersion = "2.6.2"
  val jettyVersion = "9.3.0.v20150612"
  val metricsVersion = "3.0.2"
  Seq(
    "net.liftweb" %% "lift-webkit" % liftVersion,
    "net.liftweb" %% "lift-mapper" % liftVersion,
    "net.liftweb" %% "lift-actor" % liftVersion,
    "net.liftweb" %% "lift-util" % liftVersion,
    "net.liftweb" %% "lift-squeryl-record" % liftVersion,
    "net.liftmodules" %% "lift-jquery-module_2.6" % "2.8",
    "net.databinder.dispatch" %% "dispatch-core" % "0.11.3",
    "org.eclipse.jetty" % "jetty-webapp" % jettyVersion % "container,test",
    "org.eclipse.jetty" % "jetty-plus" % jettyVersion % "container,test", // For Jetty Config
    "javax.servlet" % "javax.servlet-api" % "3.1.0" % "provided,container,test" artifacts Artifact("javax.servlet-api", "jar", "jar"),
    "org.json4s" %% "json4s-native" % "3.2.11",
    "ch.qos.logback" % "logback-classic" % "1.1.3",
    "com.codahale.metrics" % "metrics-core" % metricsVersion,
    "com.codahale.metrics" % "metrics-healthchecks" % metricsVersion,
    "com.zaxxer" % "HikariCP" % "2.3.8",
    "mysql" % "mysql-connector-java" % "5.1.36",
    "org.javassist" % "javassist" % "3.20.0-GA",
    "org.slf4j" % "slf4j-log4j12" % "1.7.12"
  )
}

webSettings

env in Compile := Some(file("./src/main/webapp/WEB-INF/jetty-env.xml").asFile)
port in container.Configuration := 8081

ivyScala := ivyScala.value map {
  _.copy(overrideScalaVersion = true)
}

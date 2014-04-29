addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "2.4.0")

addSbtPlugin("org.xerial.sbt" % "sbt-sonatype" % "0.2.0")

addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "1.5.1")

addSbtPlugin("com.github.gseitz" % "sbt-release" % "0.7.1")

addSbtPlugin("com.mojolly.scalate" % "xsbt-scalate-generator" % "0.4.2")

libraryDependencies <+= sbtVersion("org.scala-sbt" % "scripted-plugin" % _)

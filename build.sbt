import SonatypeKeys._
import xerial.sbt.Config

sonatypeSettings

profileName := "org.xerial"

credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")


publishTo := Some(Config.nexusPublishPath(version.value))
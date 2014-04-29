package xerial.sbt

import java.io.File
import java.io.FileInputStream
import java.io.InputStream
import java.util.Properties
import sbt._


object Config {
	val CONFIG_NEXUS_ROOT = "nexus.root"
	val CONFIG_NEXUS_RELEASES_PATH = "nexus.releasesPath"
	val CONFIG_NEXUS_SNAPSHOTS_PATH = "nexus.snapshotPath"

	private def loadUserSetting() :  Properties = {
	    val userHome = System getProperty "user.home"
	    val settingsFile = new File(userHome,".sbt/sbt-pack-build.settings")
	    if (settingsFile.exists()){
	      val inputStream = new FileInputStream(settingsFile)
	      try{
	        val configProp = new Properties()
	        configProp.load(inputStream)
	        return configProp
	      }catch {case e: Exception => 
	        e.printStackTrace()
	        return new Properties()
	      }finally{
	        inputStream.close()
	      }
	    }else{
	      return new Properties()      
	    }
	}

	lazy val userSettings = loadUserSetting()

	private def nexusPublishPath(nexus:String,v: String) : sbt.Resolver = {
		if (v.trim.endsWith("SNAPSHOT")){
		  "snapshots" at nexus + (userSettings getProperty CONFIG_NEXUS_SNAPSHOTS_PATH)
		}else{
		  "releases" at nexus + (userSettings getProperty CONFIG_NEXUS_RELEASES_PATH)
		}
	}

	def nexusPublishPath(version: String) : Resolver = {
		nexusPublishPath(userSettings.getProperty(CONFIG_NEXUS_ROOT),version)
	}

}
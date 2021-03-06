organization := "hr.element.etb"

name         := "etb-name_compare"

version      := "0.0.1"


// ### Build settings ###

resolvers := Seq(
  "Element Nexus" at "http://maven.element.hr/nexus/content/groups/public/"
, "Element Releases" at "http://maven.element.hr/nexus/content/repositories/releases/"
)

libraryDependencies += "com.ibm.icu" % "icu4j" % "49.1"

libraryDependencies += "uk.ac.shef.wit.simmetrics" % "simmetrics" % "1.6.2"

libraryDependencies += "org.scalatest" %% "scalatest" % "1.7.1" % "test"


scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "UTF-8", "-optimise")

unmanagedSourceDirectories in Compile <<= (scalaSource in Compile)( _ :: Nil)

unmanagedSourceDirectories in Test    <<= (scalaSource in Test   )( _ :: Nil)

publishTo <<= resolvers { _.lastOption }

credentials += Credentials(Path.userHome / ".publish" / "element.credentials")
// ### Misc ###

//initialCommands := "import hr.element.doit.csv._"

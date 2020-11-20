lazy val scalaXml = "org.scala-lang.modules" %% "scala-xml" % "1.0.6"
lazy val scalaParser = "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.6"
lazy val dispatchV = "0.12.0"
lazy val dispatch = "net.databinder.dispatch" %% "dispatch-core" % dispatchV
lazy val scalacheck = "org.scalacheck" %% "scalacheck" % "1.14.1"
lazy val scalachecktoolbox = "com.47deg" %% "scalacheck-toolbox-datetime"    % "0.4.0"
lazy val monocle = "com.github.julien-truffaut" %% "monocle-core" % "2.1.0"
lazy val monocleMacro =  "com.github.julien-truffaut" %%  "monocle-macro" % "2.1.0"

lazy val root = (project in file(".")).
  enablePlugins(ScalaxbPlugin).
  settings(inThisBuild(List(
    organization  := "com.example",
    scalaVersion  := "2.12.3"
  ))).
  settings(
    name          := "scalaxb-sample",
    libraryDependencies ++= Seq(dispatch, scalacheck, scalachecktoolbox, monocle, monocleMacro),
    libraryDependencies ++= {
      if (scalaVersion.value startsWith "2.10") Seq()
      else Seq(scalaXml, scalaParser)
    }).
  settings(
    scalaxbDispatchVersion in (Compile, scalaxb) := dispatchV,
    scalaxbPackageName in (Compile, scalaxb)     := "generated",
    // scalaxbPackageNames in (Compile, scalaxb)    := Map(uri("http://schemas.microsoft.com/2003/10/Serialization/") -> "microsoft.serialization"),
    // logLevel in (Compile, scalaxb) := Level.Debug
//    scalaxbCapitalizeWords in (Compile, scalaxb) := true,
      scalaxbGenerateLens in (Compile, scalaxb) := true,
      scalaxbGenerateScalacheckGenerator in (Compile, scalaxb) := true,
//    scalaxbXsdSource in (Compile, scalaxb) := new File("xsd")
  )

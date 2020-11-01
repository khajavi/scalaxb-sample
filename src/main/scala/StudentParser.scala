import java.io.InputStream

import generated.StudentType

import scala.xml.XML

object StudentParser extends App {
  private def resource(filename: String): InputStream =
    getClass.getResourceAsStream(filename)
  val xml    = XML.load(resource("student.xml"))
  val student    = scalaxb.fromXML[StudentType](xml)
  println(student.birthdate)
}

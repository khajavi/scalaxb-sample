import java.io.InputStream

import generated.StudentType

import scala.xml.XML

object StudentParser extends App {
  private def resource(file: String): InputStream =
    getClass.getResourceAsStream(file)
  val xml = XML.load(resource("student.xml"))
  val student = scalaxb.fromXML[StudentType](xml)
  println(student.birthdate)

  println(scalaxb.toXML(student, None, "f", generated.defaultScope))
}

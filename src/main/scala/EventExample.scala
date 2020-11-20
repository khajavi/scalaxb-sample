import generated.Event
import org.scalacheck.Gen
import org.scalacheck.rng.Seed

object EventExample extends App {
  private val event =
    Event.eventGen(Gen.Parameters.default, Seed.random())
  println(event)

  val datatypeFactory = javax.xml.datatype.DatatypeFactory.newInstance()
  val res = Event.location.modify(_ => "Old National Library")(
    Event(
      datatypeFactory.newXMLGregorianCalendar(),
      "National Library"
    )
  )
  println(res.location)

}

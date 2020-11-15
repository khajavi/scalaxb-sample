import generated.Birthdate
import org.scalacheck.Gen
import org.scalacheck.rng.Seed

object DateTimeExample extends App {
  private val birthdate =
    Birthdate.birthdateGen(Gen.Parameters.default, Seed.random())
  println(birthdate)
}

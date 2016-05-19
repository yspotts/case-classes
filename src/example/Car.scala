package example

case class Car(make: String, model: String, year: Int)

case class CurriedCar(make: String)(val model: String, val year: Int)

case class CurriedCarAlt(make: String)(model: String, year: Int)




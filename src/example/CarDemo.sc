import example.{Car, CurriedCar, CurriedCarAlt}

val car1 = new Car("Toyota", "Camry", 1998)
val car2 = Car.apply("Toyota", "Camry", 1998)
val car3 = Car("Toyota", "Sienna", 1998)

car1 == car2
car1 == car3

car1 eq car2

car1.hashCode()
car1.toString

// immutable, this will not compile if uncommented
//car1.make = "Dodge"

val car4 = car3.copy(year = 2001)
car3 eq car4

val Car(_,model,year) = car1

val car5 = Car("Dodge","Caravan",2010)
val car6 = Car("Geo","Metro",1995)

val cars = List(car1, car2, car3, car4, car5, car6)

for (car <- cars) {
  car match {
    case Car(m@"Toyota",_,_) => println(s"($m) Make America Great Again")
    case Car(m@"Dodge",_,_) => println(s"($m)Thanks for being a patriot")
    case _ => println("I'm confused")
  }
}

for (car <- cars) {
  car match {
    case Car("Toyota",_,_) => println("This thing will run forever")
    case Car(_,_,y) if y < 2010 => println("Buy a new car")
    // if the next line is commented out, an exception will be thrown
    // as the pattern matching is not exhaustive
    case Car(_, _, _) => println ("You're good")
  }
}

car1.productIterator.foreach(println _)

val carMaker = Car.curried
carMaker("Mazda")("626")(2012)

val fordMaker = Car.curried("Ford")
fordMaker("Escort")(1985)

val appliedCarMaker = Car.apply _
appliedCarMaker("Honda", "Accord", 1990)

val tupledCarMaker = Car.tupled
tupledCarMaker("Porsche", "911", 2000)

val ccar1 = CurriedCar("Toyota")("Camry", 1998)
val ccar2 = CurriedCar("Toyota")("Sienna", 2001)
ccar2.model

ccar1 == ccar2

val ccarAlt = CurriedCarAlt("Toyota")("Camry",1998)
// the following line will not compile,
// since the second parameter list variables
// are not defined as vals

//ccarAlt.model













object Util {
  fun getNumberOfCores() = Runtime.getRuntime().availableProcessors()
} 

class Car {                         
  companion object { //May optionally take a name after object, for example CarKind
    fun kind() = "Electric"
  }         
  
  fun drive() { println("driving") }
}

println(Util.getNumberOfCores())

val car = Car()
car.drive()

println(Car.kind())

val companion = Car.Companion //If CarKind is used above, then Car.CarKind
println(companion)
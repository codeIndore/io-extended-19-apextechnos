class Car {
  var yearOfRegistration = 2010
//    set(value) {
//      if(value > 2017)
//        throw RuntimeException("can't register into the future")
//      field = value
//    }
  
  val yearsSinceRegistration
    get() = 2017 - yearOfRegistration
}

val car = Car()

println(car.yearOfRegistration)

car.yearOfRegistration = 2014

println(car.yearOfRegistration)

println(car.yearsSinceRegistration)

//car.yearOfRegistration = 2019
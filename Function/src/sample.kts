fun greet(name: String) = "Hello $name"

println(greet("Bob"))

fun greet2(name: String) : String {
  return "Howdy $name"
}

println(greet2("Jane"))

fun printGreet(name: String) {
  println("Hi $name")
}

printGreet("Mike")
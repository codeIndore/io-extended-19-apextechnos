open class Person(val first: String, val last: String) {
  open fun work() { println("working...") }

  override fun toString() = "$first $last"
}

class CoolPerson(first : String, last: String) : Person(first, last) {
  var coolnessIndex = 5
  
  constructor(first: String, last: String, index: Int) : this(first, last) {
    coolnessIndex = index
  }                                              
  
  override fun work() {
    println("overridden work")
    super.work()
  }
  
  override fun toString() = "${super.toString()} ${coolnessIndex}"
}

val coolPerson = CoolPerson("Alan", "Turing", 10)
println(coolPerson)
coolPerson.work()
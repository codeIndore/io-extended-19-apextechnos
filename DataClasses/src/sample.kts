data class Person(val first: String, val last: String)

val peter = Person("Peter", "Parker")

println(peter)
println(peter.first)
println(peter.component1())            
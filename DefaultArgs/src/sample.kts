fun greet(name: String, msg: String = "Hi ${name.length}") = "$msg $name"

println(greet("Tom", "Hello"))
println(greet("Jerry"))
println(greet(msg = "Howdy", name = "Spike"))
println(greet("Tyke", msg = "Yo"))
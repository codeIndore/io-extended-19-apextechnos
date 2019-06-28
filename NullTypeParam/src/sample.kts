fun receive1(name: String?) {
  //println(name.length) //ERROR
  
  if(name != null)
    println("Size is ${name.length}") //auto casting
  else
    println("Size is 0")
}

fun receive2(name: String?) {
  println("Size is ${name?.length ?: 0}")
}

receive1("Joe")
receive1(null)

receive2("Joe")
receive2(null)
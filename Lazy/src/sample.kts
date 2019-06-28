fun compute(n: Int) : Int {
  println("called...")
  return n
}

val x = 4

if(x > 4 && compute(4) > 2)
  println("result")

println("----")  

val temp = compute(4)
if(x > 4 && temp > 2)
  println("result")

println("----")  

val temp2 by lazy { compute(4) }
if(x > 4 && temp2 > 2)
  println("result")


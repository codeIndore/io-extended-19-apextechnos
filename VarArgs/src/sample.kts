fun max(vararg numbers: Int) = numbers.reduce { max, e -> if(max < e) e else max }

println(max(1, 2))
println(max(7, 3, 11))

val values = intArrayOf(1, 22, 4)
println(max(4, 5, *values, 8))
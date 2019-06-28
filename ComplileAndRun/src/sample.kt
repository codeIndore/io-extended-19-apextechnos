fun main(args: Array<String>) {
  println("Hello ${args[0]}")
}

/*
kotlinc sample.kt -include-runtime -d sample.jar
java -classpath sample.jar SampleKt World

or

kotlinc sample.kt -d classes
kotlin -classpath classes SampleKt World
*/
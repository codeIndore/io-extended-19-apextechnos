class Robot {
  val left = "Left"
  val right = "Right"
  val fast = "Fast"
  
  infix fun turns(direction: String) {
    println("turns $direction")
  }
  
  infix fun runs(speed: String) {
    println("runs $speed")
  }
}

fun operate(func: Robot.(theRobot: Robot) -> Unit) {
  val robot = Robot()
  robot.func(robot)
}
       
operate {        
  it turns left
  it turns right
  it runs fast
}

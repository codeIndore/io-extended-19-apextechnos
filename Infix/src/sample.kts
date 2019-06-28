class Pizza {
  infix fun spread(item: String) {
    println("spreading $item")
  }
}

val pizza = Pizza()

pizza.spread("Sauce")
pizza.spread("Cheese")

pizza spread "Sauce"
pizza spread "Cheese"
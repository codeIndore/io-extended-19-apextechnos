val name = "Job"

val memo = """
  |This message was created by $name and
  |is being delivered
  |securty to...
"""

println(memo)

println(memo.trimMargin())

println(memo.trimMargin("|")) //replace | with ~, for example.
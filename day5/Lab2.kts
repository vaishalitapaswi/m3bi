val theList = listOf("one", "two", "three")
theList.size
val secondlist = theList.slice(0..1)
println(secondlist)
val theMutableList = mutableListOf("one", "two", "three","four")
theMutableList.add(2,"");
println(theMutableList)

println(theMutableList.filter { it.length > 3 })
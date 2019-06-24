val theList = listOf("one", "two", "three")
theList.size
theList.forEach {
    println(it)
}
val theMutableList = mutableListOf("one", "two", "three","four")
theMutableList.size
theMutableList.add("four")
theMutableList.size
theMutableList.forEach {
    println(it)
}
val theSet = setOf("one", "two", "three")
val theMutableSet = mutableSetOf("one", "two", "three")

theMutableSet.add("aaa")
theMutableSet.forEach {
    println(it)
}
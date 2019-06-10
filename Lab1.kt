fun main() {
    println("Hello, world!!!")
    val k = 10

    val sum = {i:Int,j:Int->i+j}
    val sum1 = {i:Double,j:Double->i+j}
    val sum2= {i:Int, j:String->"aaaa"}
	println("Value of  k = "+ k)
    println("Output = " + sum(10,100) )
    println("Sum1 =" + sum1(10.7,10.77))
    
}

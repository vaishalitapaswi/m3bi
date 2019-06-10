

fun main() {
    val add = {i:Int,j:Int->i+j}
    val sub = {i:Int,j:Int->i+j}
    val concat = {i:String,j:String->i+j}
    val div = {i:Int,j:Int->i+j}
    val a:String= "aa"
    
    val calc ={ i:Int,j:Int, op:(Int,Int)->Int-> 10}
    
   println(calc(10,20,add))
    println(calc(100,2000,sub))
   println(concat("aaaa","bbbb"))
    
    
}

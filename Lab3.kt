const val s="AAA"

fun main() {
var k = 10;
val cal:Int by lazy {k+100};
//val cal= k+100  //(declaring cal variable ) ->initialze cal to 110
k = 20
println("k = " + k);
println("cal = " + cal);
k = 30   
println("cal = " + cal);    
    

}

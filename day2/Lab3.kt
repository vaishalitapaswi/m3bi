package com.example.demo1
fun checkString(a:String):String =
     when(a.length){
        in 0..5 -> "small string"
        in 5..10 -> "big string"
        else -> "NotKnown"
    }

fun main() {
    println("check string for str11 = " + checkString("straaa11") );
    val x = 5
    when (x) {
        0,1 -> print("x == 1 or 0")
        2 -> print("x == 2")
        in 3..6 -> println("in 3..6")
        else -> { // Note the block
            print("x is neither 1 nor 2")
        }
    }

    val str = "hello"
   val info =  when (str.length){
        in 0..5 -> "its small string"
        in 5..10 -> "its Big string"
       else -> "Not Known ..."
    }
    println("for str = $str , count  = $info")




}


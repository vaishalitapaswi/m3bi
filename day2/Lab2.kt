package com.example.demo1


// readability, concise code
// smaller
fun max(i :Int, j :Int):Int{
    if (i > j)
        return i
    else
        return j
}

fun max2(i:Int, j:Int)= if (i> j) i else  j

fun main() {
    val a = 40
    val b  = 20

    val c =  if (a> b){
        println("in if")
        a
    } else {
        println("in else")
        b
    }
    println("c = $c")
    println("max(30,20) " + max(30,20));
    println("max (10,40) = ${max (10,40)}")
    println("max (10,10) = ${max (10,10)}")
    println("max2(30,20) " + max2(30,20));
    println("max2 (10,40) = ${max2 (10,40)}")
    println("max2 (10,10) = ${max2 (10,10)}")
}


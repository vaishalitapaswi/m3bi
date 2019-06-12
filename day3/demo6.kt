package com.example.demo1

fun main() {
    var str = "Hello World "
    println(str)
    println(str.shout("aa"))

}


infix fun String.shout(s:String):String
{return this.toUpperCase()+s}

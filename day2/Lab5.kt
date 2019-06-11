package com.example.demo1

import java.util.Date

fun main() {
    println("Hello, please enter your name" )
    val str = readLine()
    println("Your name is " + str)

    val array = Array(5, {x-> "str"+(x+10)} )
    array[1]="strOne"
    println(array[1])


}


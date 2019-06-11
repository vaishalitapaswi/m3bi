package com.example.demo1

import java.util.Date

fun main() {




    val array = Array(5, {x-> "str"+(x+10)} )


    for (no in array) {
        println(no)
    }

    for (i in array.indices) {
        println("indices " + array[i])
    }

    for ((index, value) in array.withIndex()) {
        println("the element at $index is $value")
    }


}


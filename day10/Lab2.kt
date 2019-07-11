package com.example.part2.demo11

import kotlinx.coroutines.*

fun main()= runBlocking {
    var count = 0
    for(i in 1..10){
    val r1 = GlobalScope.launch { // launch a new coroutine in background and continue
        println("in r1, current value of count = " + count)
        var temp = count
        temp++
        delay(500);
        count = temp
        println("in r1, modified current value of count = " + count)
    }}
    for(i in 1..10){
val r2 = GlobalScope.launch { // launch a new coroutine in background and continue
    println("in r2s, current value of count = " + count)
    var temp = count
    temp--
    delay(500);
    count = temp
    println("in r2s, modified current value of count = " + count)
}}
    Thread.sleep(10000)
}

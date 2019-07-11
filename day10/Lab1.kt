package com.example.part2.demo11

import kotlinx.coroutines.*

fun main()= runBlocking {

   val r1 = GlobalScope.launch { // launch a new coroutine in background and continue
        println("globalscope launch 1")
      //  delay(1000L) // non-blocking delay for 1 second (default time unit is ms)
       Thread.sleep(1500)
        println("World1111") // print after delay
    }
   val r2= GlobalScope.launch { // launch a new coroutine in background and continue
        println("globalscope launch 2")
        delay(1000L) // non-blocking delay for 1 second (default time unit is ms)
        println("World2222") // print after delay
    }

    println("Hello,") // main thread continues while coroutine is delayed
    r1.join();
   // delay(2000);
    //Thread.sleep(2000L) // block main thread for 2 seconds to keep JVM alive
}
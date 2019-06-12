package com.example.demo1

import java.util.Date
class Info{
    var nm:String="a"
        set(value) {
            marks = value.length
            println("set value = $value" )
        }
    var marks:Int=20
    set(value)=  println("set value = $value" )
}


fun main() {
var info =Info()
    info.nm = "TestOne"
    info.marks=3000
    println(" info =  ${info.nm} , ${info.marks}")


}

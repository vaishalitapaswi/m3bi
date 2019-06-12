package com.example.demo1

import java.util.Date
class Simple{
    var name :String ="aa".also(::println)
    var mark:Int = 0
    constructor(_name:String){
        println(" in constructor with name  $name" )
       name = _name
    }
    constructor(_name:String, _marks:Int=0){
        this.name = _name
        this.mark = _marks
        println(" in constructor with name and marks ... $name $mark" )
    }

    init{
        println("in init after constructor ......")
    }

    fun m1(){
        println("m1 of student1 and name = $name" )
    }
    init{
        println("in init after m1 ......")
    }
}
fun main() {
    val s = Simple("aaa",_marks = 3000)
    s.m1()
    val s11 = Simple("aaa",_marks = 3000)
    s11.m1()
}

package com.example.demo1

import java.util.Date
class Sstd2(val name:String?=null, var marks:Int=0){
    val len  = name?.length
    init{
        println("name = $name and marks = $marks")
    }
    fun m1(){
        println("m1 of student1 and name = $name, marks = $marks" )
    }
}

class Std1( _name:String="aaa",  _marks:Int=0){
    fun m1(){
        println("m1 of student1 and name = $name, marks = $marks" )
    }
    var name = _name
    init{
        println("in init after name .param..." + _name + ", " + _marks)
    }
    var marks = _marks
    init{
        println("in init after marks s ...." +  _name + ", " + _marks)
        println("in init after name .class ..." + name + ", " + marks)
    }

}

fun main() {

  val test = Std1(_marks = 400)

    test.m1()

    test.name="change"
    test.marks=4000
    test.m1()




}



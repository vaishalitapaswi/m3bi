package com.example.demo1

import java.util.Date
class Test1(val name:String?=null, var marks:Int=0){
    val len  = name?.length
    fun m1(){
        println("m1 of student1 and name = $name, marks = $marks" )
    }
}
class Test2( _name:String, _marks:Int=0){
    val name = _name
    val marks = _marks + 10
    val grade = if (_marks > 35) "pass" else "fail"
    val len  = _name.length
    fun m1(){
        println("m1 of student1 and name = $name, marks = $marks with grade =  $grade"   )

    }
}

fun main() {

    val test = Test2("test1111",_marks = 120)
  //  val test = Test1("test1111",marks = 120)
  //  test.marks = 3000
    test.m1()
    /*val test = Test()
    test.name="Vaishali"
    test.m1()*/

}


class Test{
    // fields
   var name = "aaa"
    // methods
    fun m1(){
        println("m1 of student1 and name = $name" )
    }
}



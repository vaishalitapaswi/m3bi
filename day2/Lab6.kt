package com.example.demo1

data class Student(var name: String, var marks: Int)
fun main() {
    val std:Student = Student("aaa",30)
    val std1 = Student(marks = 400,name = "bbb")
   var std2 = Student(marks=0,name="a")
    println("Hello, please enter your name" )
    val str =  readLine()
    std2.name = str?:"undefineds"

    println("Hello, please enter your Age" )
    std2.marks =  readLine()?.toInt()?:0


    println(std)
    println(std1)
    println(std2)
}


package com.example.demo1

data class Student1(val name: String, val marks: Int)

fun main() {


    println("Enter choice")
    val array = Array(5, { x -> Student("", 0) })
    println("Please enter your choice 1/..")
    var choice = readLine()
    if (choice.equals("1")) {
        println("Enter Name")
        val name = readLine()
        println("Enter Marks")
        var marksstr= readLine()
        marksstr = null
        //val marks = readLine()?.toInt() ?: 35
        val marks = when (marksstr) {
            null -> 0
            ""->10
            else -> 35
        }



        val std: Student = Student(name ?: "undefined", marks = marks)
        println(std)
    } else {
        for ((index, value) in array.withIndex()) {
            println("the element at $index is $value")
        }
    }
}
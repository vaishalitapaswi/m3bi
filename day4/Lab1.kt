package com.example.demo1.com.example.demo1.com.example.day4


import kotlin.collections.ArrayList

//Employee Struct
data class Employee (val empNo:Int, val empName:String, val empSalary:Double) { }
data class Dept (val deptno:Int, val dname :String, val loc:String){}
val testdelemp= {e:Employee,e1:Employee ->  e.empNo == e1.empNo}
val testdeldept= {e:Dept,e1:Dept -> e.deptno == e1.deptno}

//Employee Manager

class Manager<T>
{
    private val collection :MutableList<T> = ArrayList()

    fun add(dataobj:T) =  collection.add(dataobj)
    fun update(index:Int, obj:T)= collection.set(index,obj)
    fun fetch(index:Int) : T = collection.get(index)
    fun remove(obj:T, testdel:(T,T)->Boolean) ={
        println("in remove  $obj")
        collection.forEach {
            val bool = testdel(it, obj)
            if (bool == true) {
                println("in if " + bool)
                collection.remove(it)
            }
        }
    }
  fun listall() = collection.forEach(::println)
}


fun main() {
    val empManager = Manager<Employee>()

    for (i in 1..5)
    {
        var emp = Employee(empNo = i, empName = "Emp"+i, empSalary = i*1000.0)
        empManager.add(emp)
    }
    var emp = Employee(empNo = 3, empName = "Emp2", empSalary = 2000.0)
    empManager.remove(emp, testdelemp)
//    empManager.remove(emp,testdelemp)

//    var emp1 = Employee(empNo = 1, empName = "Vaishali", empSalary = 11111.10)
 //s   empManager.update(1,emp1)
    empManager.listall()

}

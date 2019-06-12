package com.example.demo1

interface  myint
{
    fun test()
    fun test(no:Int)
}
open class MyImpl : myint{
   override fun test() {
        println("myimpl - test ")
    }
   override fun test(no: Int) {
        println("myimpl - test wiht param   $no")
    }
    fun test2(no: Int) {
        println("myimpl - test2 wiht param   $no")
    }
}
class MyDerived() : MyImpl() { // compile time relationship -> tightcoupled
    fun der1(){
    }
}
class MyCustomCode(delegatingtosomeclass:myint):myint by delegatingtosomeclass
{

}

fun main() {
    var dqq = MyCustomCode(MyImpl())
    dqq.test()
    dqq.test(10)

    var d = MyDerived()
    d.test()
    d.test(11)
    /*   var v1 : MyImpl = MyImpl()

var v2 : MyImpl= MyDerived()
    var v3 = MyDerived()
    var v1:myint = MyImpl()
*/

}



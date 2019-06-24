data class Emp (val empno:Int, val eName:String, val salary:Int) { }

val empList = List(5, {Emp((it+1), "Vimal"+(it+1), 10*(it+1))})
empList.forEach {
    println(it)
}

empList.forEach {
    println("EMP:"+it.eName)
}

empList.filter{it.empno <2}.forEach{println(it)}


val modifiedlist = empList.map { Emp(it.empno,it.eName.toUpperCase(),it.salary * 70 )}
modifiedlist.forEach({ println(it)})


empList.fold(0,{ sum,e->sum+e.salary})
modifiedlist.fold(0,{ sum,e->sum+e.salary})
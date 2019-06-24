data class Emp (val empno:Int, val ename:String, val salary:Int) { }

var myList: MutableList<Emp> = mutableListOf<Emp>()

myList.add(Emp(1001, "Test", 500))
myList.add(Emp(1002, "Test2", 1700))
myList.add(Emp(1003, "Test3", 1900))
myList.add(Emp(1004, "Test4", 140))
myList.add(Emp(1005, "Test5", 1080))
myList.add(Emp(1006, "Test6", 1410))
myList.add(Emp(1007, "Test7", 4550))
myList.add(Emp(1008, "Test8", 800))
myList.add(Emp(1009, "Test9", 1000))
println(myList.size)
var sortedlist = myList.sortedBy { emp-> emp.salary }
sortedlist.forEach{println(it)}
var sortedList1 = myList.parallelStream().sorted({e,e1 -> e.empno.compareTo(e1.empno)})
sortedList1.forEach{println(it)}





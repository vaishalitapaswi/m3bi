fun main(args: Array<String>) {
    var mgrpointer = EmpManager().initialize();
}

class EmpManager
{
    constructor() {
        println("in constructor")
    }
    fun initialize():Array<( arg:Emp? )->Any?>
    {
        var list:MutableList<Emp> = ArrayList<Emp>()
        var arr = arrayOf<(Emp?)->Any?>(
            {e:Emp? -> list},
            {e1:Emp? ->e1?.let{list.add(e1)};true}
        )
        return arr;
    }
}
class EmpManagerSpecific
{
   private var list:MutableList<Emp> = ArrayList<Emp>()
    fun create(e:Emp){
        list.add(e)
    }
    fun list():List<Emp>{
        return list;
    }
}

import org.litote.kmongo.* //NEEDED! import KMongo extensions

fun main(args: Array<String>) {
    val repo = MongoCRUDRepo()
    for (i in 1..10) {
        val e = Emp(i, "Name$i", i * 1000.0)
        repo.create(e)
    }
  /*  val d: Emp = Emp(empno = 1)
    print("Returned for delete =  ${repo.delete(d)}");
    val d1: Emp = Emp(2, ename = "Vaishali", salary = 2222.0)
    repo.update(d1);
    val list = repo.list()
    for (d in list)
        println(d)
        */
}

class MongoCRUDRepo {
    private val client = KMongo.createClient() //get com.mongodb.MongoClient new instance
    val database = client.getDatabase("test") //normal java driver usage
    val col = database.getCollection<Emp>() //KMongo extension method
    fun create(emp: Emp) {
        col.insertOne(emp)
    }
}
   /* fun update(Emp: Emp){
        val con:Connection = opencon()
        val stmt:Statement = con.createStatement();
        val sql = " update Emp set dname='${Emp.dname}' , loc='${Emp.loc}' where Empno  = ${Emp.Empno}"
        println(sql)
        stmt.execute(sql)
        println("updated")
        con.close()
    }
    fun delete(Emp:Emp):Boolean{
        val con:Connection = opencon()
        val sql = " delete from Emp where Empno  = ${Emp.Empno}"
        val stmt:Statement = con.createStatement();
        println(sql)
        val bool= stmt.execute(sql)
        println("deleted")
        con.close()
        return bool
    }
    fun list():List<Emp>
    {  val con:Connection = opencon()
        val sql = " select * from Emp"
        val stmt:Statement = con.createStatement();
        val rs:ResultSet =stmt.executeQuery(sql)
        //var list: MutableList<ArrayList<Emp>> = MutableList<ArrayList<Emp>>(size = 10,init = null);
        val list: MutableList<Emp> = ArrayList()
        while(rs.next())
        {
            val d:Emp = Emp(Empno = rs.getInt(1),dname=rs.getString(2),loc=rs.getString(3))
            list.add(d)
        }
        con.close()
        return list;
    }
}*/
data class Emp(val empno: Int, val ename:String,val salary:Double);

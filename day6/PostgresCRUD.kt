import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement

fun main(args: Array<String>) {
    val repo= PostgresCRUDRepo()
    for(i in 1..10)
    {
        val d:Dept
        if (i %2 ==0)
            d = Dept(i,"Dname $i" ,"Hyd")
        else
            d = Dept(i,"Dname $i" ,"Pnq")
        repo.create(d)
    }
    val d:Dept = Dept(2,dname = "ddd",loc="loc")
    print("Returned for delete =  ${repo.delete(d)}");
    val d1:Dept = Dept(1,dname = "HR",loc="Blr")
    repo.update(d1);
    val list = repo.list()
    for ( d in list)
        println(d)

}

class PostgresCRUDRepo{

    val classname="org.postgresql.Driver"
    fun opencon(url:String="jdbc:postgresql://localhost:5432/test",user:String="postgres",password:String="postgres"):Connection{
        Class.forName(classname);
        return DriverManager.getConnection(url,user,password);
    }
    fun create(dept: Dept){
        val con:Connection = opencon()
        val stmt:Statement = con.createStatement();
        val sql = "insert into Dept values (${dept.deptno},'${dept.dname}','${dept.loc}')"
        println(sql)
        stmt.execute(sql)
        println("inserted")
        con.close()
    }
    fun update(dept: Dept){
        val con:Connection = opencon()
        val stmt:Statement = con.createStatement();
        val sql = " update dept set dname='${dept.dname}' , loc='${dept.loc}' where deptno  = ${dept.deptno}"
        println(sql)
        stmt.execute(sql)
        println("updated")
        con.close()
    }
    fun delete(dept:Dept):Boolean{
        val con:Connection = opencon()
        val sql = " delete from Dept where deptno  = ${dept.deptno}"
        val stmt:Statement = con.createStatement();
        println(sql)
        val bool= stmt.execute(sql)
        println("deleted")
        con.close()
        return bool
    }
    fun list():List<Dept>
    {  val con:Connection = opencon()
        val sql = " select * from Dept"
        val stmt:Statement = con.createStatement();
        val rs:ResultSet =stmt.executeQuery(sql)
        //var list: MutableList<ArrayList<Dept>> = MutableList<ArrayList<Dept>>(size = 10,init = null);
        val list: MutableList<Dept> = ArrayList()
        while(rs.next())
        {
            val d:Dept = Dept(deptno = rs.getInt(1),dname=rs.getString(2),loc=rs.getString(3))
            list.add(d)
        }
        con.close()
        return list;
    }
}
data class Dept(val deptno: Int, val dname:String,val loc:String);

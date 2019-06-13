import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable

class EmpManagerTest {

    @Test
    fun testadd() {
        val mgrpointer = EmpManager().initialize();
        val add = Address("maggarpatta","hadapsar","Pnq","Mh")
        val emp = Emp(1,"Vaishali",111.1,add);
        mgrpointer[1](emp)
    }

   @Test
    fun testemptylist() {
        val mgrpointer = EmpManager().initialize();
        val coll= mgrpointer[0](null);
        var cnt =  if (coll is List<*>)  ((coll.filterIsInstance<Emp>()).size) else 0
        Assertions.assertEquals(0,cnt)
    }

    @Test
    fun testavalist() {
        val empmgr = EmpManager()
        val mgrpointer = EmpManager().initialize();
        val coll= mgrpointer[0](null);
        var cnt =  if (coll is List<*>)  ((coll.filterIsInstance<Emp>()).size) else 0
        val add = Address("maggarpatta","hadapsar","Pnq","Mh")
        val emp = Emp(1,"Vaishali",111.1,add);
        mgrpointer[1](emp);
        val coll1= mgrpointer[0](null);
        var cnt1 =  if (coll1 is List<*>)  ((coll1.filterIsInstance<Emp>()).size) else 0
        Assertions.assertEquals(cnt, cnt1 - 1)
    }
}
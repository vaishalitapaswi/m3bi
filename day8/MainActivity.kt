package day7.demo

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView

import kotlinx.android.synthetic.main.activity_main.*
data class Emp (val empno:Int, val ename : String, val salary:Int)
class MainActivity : AppCompatActivity() {
    fun listhandler(view:View){
        println("List Handler invoked ..");
        val db= DatabaseHandler(this.applicationContext)
        var str = ""
        db.listEmployee().forEach{str+=it}
        val view4:TextView = findViewById(R.id.dispText) as TextView
        view4.setText(str)
    }
    fun deletehandler(view:View){
        val db= DatabaseHandler(this.applicationContext)
        val view1: TextView = findViewById(R.id.empno) as TextView
        val empno = view1.text.toString().toInt()
        val cnt = db.deleteEmployee("empno =" + empno,null);
        val view4:TextView = findViewById(R.id.dispText) as TextView
        view4.setText("Deleted $cnt")
    }
    fun addhandler(view:View){
            val db= DatabaseHandler(this.applicationContext)

        val view1: TextView = findViewById(R.id.empno) as TextView
        val view2: TextView = findViewById(R.id.en) as TextView
        val view3: TextView = findViewById(R.id.sal) as TextView

        val e = Emp(view1.text.toString().toInt(), view2.text.toString(),view3.text.toString().toInt());
        val v = db.addEmployee(e)

         }
    fun updatehandler(view:View){
        val db= DatabaseHandler(this.applicationContext)

        val view1: TextView = findViewById(R.id.empno) as TextView
        val view2: TextView = findViewById(R.id.en) as TextView
        val view3: TextView = findViewById(R.id.sal) as TextView

        val e = Emp(view1.text.toString().toInt(), view2.text.toString(),view3.text.toString().toInt());
        val cnt = db.updateEmployee(e);
        val view4:TextView = findViewById(R.id.dispText) as TextView
        view4.setText("Updated $cnt")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}

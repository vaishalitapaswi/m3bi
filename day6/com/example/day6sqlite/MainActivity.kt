package com.example.day6sqlite

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.example.demo6kot.DatabaseHandler

import kotlinx.android.synthetic.main.activity_main.*
data class Emp (val empno:Int,val ename:String, val salary:Int)
class MainActivity : AppCompatActivity() {

    fun addhelper(view:View){
        val db= DatabaseHandler(this.applicationContext)
        val e = Emp(10,"One",1111);
        db.addEmployee(e)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        btnAddToDb.setOnClickListener {
            val db= DatabaseHandler(this.applicationContext)
            val e = Emp(10,"One",1111);
            db.addEmployee(e)
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

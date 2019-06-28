package day7.demo

import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteException

class DatabaseHandler(context: Context): SQLiteOpenHelper(context,DATABASE_NAME,null,DATABASE_VERSION) {
    companion object {
        private val DATABASE_VERSION = 1
        private val DATABASE_NAME = "EmployeeDatabase"
        private val TABLE_EMP = "EmployeeTable"
        private val KEY_ID = "empno"
        private val KEY_NAME = "ename"
        private val KEY_SALARY = "salary"
    }

    override fun onCreate(db: SQLiteDatabase?) {

        //creating table with fields
        val CREATE_CONTACTS_TABLE = ("CREATE TABLE " + TABLE_EMP + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_SALARY + " INTEGER" + ")")
        db?.execSQL(CREATE_CONTACTS_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS " + TABLE_EMP)
        onCreate(db)
    }


    //method to insert data
    fun addEmployee(emp: Emp): Long {
        val db = this.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(KEY_ID, emp.empno)
        contentValues.put(KEY_NAME, emp.ename)
        contentValues.put(KEY_SALARY, emp.salary)
        val success = db.insert(TABLE_EMP, null, contentValues)

        db.close()
        return success
    }
    fun updateEmployee(emp: Emp): Int {
        val db = this.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(KEY_ID, emp.empno)
        contentValues.put(KEY_NAME, emp.ename)
        contentValues.put(KEY_SALARY, emp.salary)
        val str = KEY_ID + "=" + emp.empno
        val count = db.update(TABLE_EMP,contentValues,str, null)
        db.close()
        return count;
    }
    fun deleteEmployee(where:String,whereargs:Array<String>?): Int{
        val db = this.writableDatabase
        val count = db.delete(TABLE_EMP,where,whereargs);
        db.close()
        return count;
    }
    fun listEmployee():List<Emp>
    {
        val empList:ArrayList<Emp> = ArrayList<Emp>()
        val db = this.readableDatabase
        val selectQuery = "SELECT  * FROM $TABLE_EMP"
        var cursor: Cursor? = null
        try{
            cursor = db.rawQuery(selectQuery, null)
        }catch (e: SQLiteException) {
            db.execSQL(selectQuery)
            return ArrayList()
        }
        var userid: Int
        var userName: String
        var usersalary: Int
        if (cursor.moveToFirst()) {
            do {
                userid = cursor.getInt(cursor.getColumnIndex("empno"))
                userName = cursor.getString(cursor.getColumnIndex("ename"))
                usersalary = cursor.getInt(cursor.getColumnIndex("salary"))
                val emp= Emp(userid, userName,usersalary)
                empList.add(emp)
            } while (cursor.moveToNext())
        }
        return empList
    }
}

package learnkotlin.blogspost.com.sqliteex01

import android.content.Context
import android.database.sqlite.SQLiteOpenHelper
import android.database.sqlite.SQLiteDatabase
import android.support.v7.widget.DialogTitle
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper


/**
 * Created by mac on 23/10/2017.
 */
class MyDBAccess(context:Context) {


    val sqldb = SQLiteAssetHelper(context,"test.sqlite",null,1).writableDatabase


    fun closeMyDB() {
        if (sqldb != null && sqldb.isOpen()) {
            sqldb.close()
        }
    }


    fun getDescription(title: String):String{
        val c = sqldb?.rawQuery("SELECT * FROM test1 WHERE title=\'$title\'", null)

        val list = (1 .. c!!.count).map {
            c.moveToNext()
            c.getString(c.getColumnIndex("body"))
        }
        c.close()


        return list[0]
    }

    fun getValueFromTableTest(): List<String>? {

        val c = sqldb?.rawQuery("SELECT * FROM test1", null)
        val list = (1 .. c!!.count).map {
            c.moveToNext()
            c.getString(c.getColumnIndex("title"))
        }
        c.close()
        return list
    }


}
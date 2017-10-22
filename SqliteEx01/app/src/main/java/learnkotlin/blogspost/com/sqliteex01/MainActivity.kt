package learnkotlin.blogspost.com.sqliteex01

import android.content.Context
import android.database.Cursor
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener







class MainActivity : AppCompatActivity() {


    var mdb:MyDBAccess? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //-----------------------------------------------
        mdb = MyDBAccess(this);
        lv1.adapter=ArrayAdapter<String>(
                this,android.R.layout.simple_list_item_1,mdb!!.getValueFromTableTest()
        )
        //--------------------------------------------------

        lv1.onItemClickListener=OnItemClickListener { adapter, v, position, arg3 ->
            val curTitle = adapter.getItemAtPosition(position) as String
            val curBody = mdb!!.getDescription(curTitle) as String
            Toast.makeText(baseContext,curBody,Toast.LENGTH_SHORT).show()
        }
        //--------------------------------------------------


    }

    override fun onDestroy() {
        super.onDestroy()
        if(mdb!=null) {
            mdb!!.closeMyDB()
        }
    }

}

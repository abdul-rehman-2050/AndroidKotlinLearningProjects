package learnkotlin.blogspost.com.sqliteex01


import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.AdapterView.OnItemClickListener







class MainActivity : AppCompatActivity() {


    var mdb:MyDBAccess? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //-----------------------------------------------
        mdb = MyDBAccess(this);
        listViewTitles.adapter=ArrayAdapter<String>(
                this,android.R.layout.simple_list_item_1,mdb!!.getValueFromTableTest()
        )
        //--------------------------------------------------

        listViewTitles.onItemClickListener=OnItemClickListener { adapter, v, position, arg3 ->
            val curTitle = adapter.getItemAtPosition(position) as String
            val curBody = mdb!!.getDescription(curTitle) as String

            val intentPost = Intent(this, ContentActivity::class.java)
            intentPost.putExtra("title",curTitle)
            intentPost.putExtra("body",curBody)
            startActivity(intentPost)

            //Toast.makeText(baseContext,curBody,Toast.LENGTH_SHORT).show()
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

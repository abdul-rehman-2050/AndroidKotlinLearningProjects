package ex01.menu.learnkotlin.com.menuex01

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mainmenu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.getItemId()) {
            R.id.app_bar_menu1 -> {
               Toast.makeText(applicationContext,"Item 1 Clicked",Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.app_bar_menu2 -> {
                Toast.makeText(applicationContext,"Item 2 Clicked",Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.app_bar_search ->{
                Toast.makeText(applicationContext,"Item Search Clicked",Toast.LENGTH_SHORT).show()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

}

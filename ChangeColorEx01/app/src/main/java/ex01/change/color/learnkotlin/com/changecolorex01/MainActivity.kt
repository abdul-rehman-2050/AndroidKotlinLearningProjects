package ex01.change.color.learnkotlin.com.changecolorex01

import android.app.TaskStackBuilder.create
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

import me.priyesh.chroma.ChromaDialog;
import me.priyesh.chroma.ColorMode;
import me.priyesh.chroma.ColorSelectListener;



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.mainmenu,menu)
        return true


    }

    private fun showColorPickerDialog() {
        ChromaDialog.Builder()
                .initialColor(Color.BLUE)
                .colorMode(ColorMode.RGB)
                .onColorSelected(object : ColorSelectListener {
                    override fun onColorSelected(color: Int) {
                       Toast.makeText(applicationContext,"Color is = "+color,Toast.LENGTH_SHORT).show()
                    }
                })
                .create()
                .show(supportFragmentManager, "dialog")
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when(item!!.itemId){
            R.id.menu_item_change_color ->{
                 ChromaDialog.Builder()
               showColorPickerDialog()
               return true

            }
            R.id.menu_item_quit ->{

                return true

            }
            else ->return super.onOptionsItemSelected(item)

        }



    }
}

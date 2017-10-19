package ex01.change.color.learnkotlin.com.changecolorex01


import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

import me.priyesh.chroma.ChromaDialog;
import me.priyesh.chroma.ColorMode;
import me.priyesh.chroma.ColorSelectListener;



import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = ArrayAdapter(
                this, android.R.layout.simple_spinner_dropdown_item, ColorMode.values())
        color_mode_spinner.setAdapter(adapter)
        color_mode_spinner.setSelection(adapter.getPosition(ColorMode.RGB))

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.mainmenu,menu)
        return true


    }

    private fun showColorPickerDialog() {
        ChromaDialog.Builder()
                .initialColor(Color.BLUE)
                .colorMode(color_mode_spinner.selectedItem as ColorMode)
                .onColorSelected(object : ColorSelectListener {
                    override fun onColorSelected(color: Int) {
                        //#TODO make use of color to change textview foreground color
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

              //#TODO implement onQuit confirmation dialog and exit application if user confirms





            }
            else ->return super.onOptionsItemSelected(item)

        }



    }
}

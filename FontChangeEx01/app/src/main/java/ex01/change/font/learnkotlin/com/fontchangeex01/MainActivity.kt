package ex01.change.font.learnkotlin.com.fontchangeex01

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import android.graphics.Typeface
import android.widget.SeekBar


class MainActivity : AppCompatActivity() {


    var cur_font_num = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fontsCollection = resources.getStringArray(R.array.urdu_fonts_array)
        textView1.text = Html.fromHtml(resources.getString(R.string.surah_fatiha_translation_urdu))
        val face = Typeface.createFromAsset(assets, "fonts/"+fontsCollection[0])
        textView1.setTypeface(face)
        textView1.textSize=23.0f



        button.setOnClickListener({

            cur_font_num++;
            if(cur_font_num>4) cur_font_num = 0

            Toast.makeText(this,fontsCollection[cur_font_num],Toast.LENGTH_SHORT).show()

            val face = Typeface.createFromAsset(assets, "fonts/"+fontsCollection[cur_font_num])
            textView1.setTypeface(face)


        })




      


    }
}

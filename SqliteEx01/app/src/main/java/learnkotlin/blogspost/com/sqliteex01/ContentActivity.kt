package learnkotlin.blogspost.com.sqliteex01

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_content.*

class ContentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)

        val title =intent.getStringExtra("title")
        val body = intent.getStringExtra("body")

        tv_body.text = body
        tv_title.text = title


    }
}

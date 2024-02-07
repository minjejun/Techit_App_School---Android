package kr.co.lion.android02_testproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView

// step 1) 화면부터 구성해줌.
// oncreate 메소드에 있는 코드 중 setContentView 메소드의 매개변수에 설정되어 있는 것을
// 확인하여 res/layout 폴더에 있는 xml 파일을 열어줌.

// step 2) Activity로 돌아와 필요한 코드들을 작성함.

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val testView1 = findViewById<TextView>(R.id.textView)

        val testView2 = findViewById<Button>(R.id.button)

        testView2.setOnClickListener(object : OnClickListener {
            override fun onClick(p0: View?) {
                testView1.text = "안녕하세요"
            }
        })
    }
}

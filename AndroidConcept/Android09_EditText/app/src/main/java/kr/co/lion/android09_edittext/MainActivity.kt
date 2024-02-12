package kr.co.lion.android09_edittext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.core.widget.addTextChangedListener
import kr.co.lion.android09_edittext.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        activityMainBinding.apply {
            // EditText
            editTextText3.apply {
                // 문자열을 설정해줌.
                setText("code로 설정한 문자열")

//                // 실시간으로 키보드 입력을 감시함
//                object : TextWatcher {
//                    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                    }
//
//                    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                    }
//
//                    override fun afterTextChanged(p0: Editable?) {
//                    }

                // 문자열을 입력할 때마다 동작.
                // it : EditText에 입력된 문자열을 가지고 옴.
                addTextChangedListener {
                    textView.text = "실시간 감지 : $it"
                }

                // 엔터키를 눌렀을 때 동작함
                setOnEditorActionListener { v , actionId, event ->

                    textView.text = "엔터키를 눌렀습니다\n"
                    textView.append("입력된 문자열 : $text")

                    // true : 리턴 키를 누른 후 포커스가 현재 EditText로 유지됨.
                    // false : 리턴 키를 누른 후 포커스가 다음 EditText로 이동됨.
                    false
                }
            }


            // button
            button.apply {
                setOnClickListener {
                    // EditText에서 문자열을 가져옴
                    // Editable 타입으로 반환되므로 String 형태로 사용하고자 한다면
                    // 변환해줘야 함.
                    val str1 = editTextText3.text.toString()
                    textView.text = str1
                }
            }
        }
    }
}
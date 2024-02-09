package kr.co.lion.android03_viewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView
import kr.co.lion.android03_viewbinding.databinding.ActivityMainBinding

// ViewBinding
// 코드를 통해 배치된 View들을 사용하기 위해서는 View 객체의 주소값을 가져와야 함
// findViewById 메소드를 이용해 원하는 View 객체의 주소값을 가져올 수 있음.

// 만약 ViewBinding을 설정하면 id가 설정되어 있는 객체의 주소값이 미리 프로퍼티에 담겨
// 있기 때문에 이것을 사용만 하면 됨.

// Setting 방법
// 1. Module 수준의 build.gradle.kts 파일을 열어서 viewBinding 작성
// 2. 작성하고 Sync Now 누름
// 3. ViewBinding 객체를 얻어옴.

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityMainBinding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(activityMainBinding.root)

        activityMainBinding.button
    }
}
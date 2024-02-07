package kr.co.lion.android01_helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    // Activity 객체가 생성되고 자동으로 호출되는 메소드
    // 이 메소드가 Activity 안에서 코드의 시작점이 됨.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Activity가 관리할 화면을 만듬
        // 매개 변수에는 화면을 만들기 위해서 필요한 정보가 담긴 xml 파일을 설정함.
        // R -> res 폴더
        // layout -> res 폴더 안에 있는 layout 폴더
        // activity_main -> layout 폴더에 있는 activity_main.xml
        setContentView(R.layout.activity_main)
    }
}
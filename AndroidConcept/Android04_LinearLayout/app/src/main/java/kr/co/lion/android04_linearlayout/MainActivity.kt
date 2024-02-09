package kr.co.lion.android04_linearlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

// LinearLayout : 방향성을 가지고 View 들을 배치하는 레이아웃

// 주요 속성
// orientation : 뷰가 배치되는 방향을 결정
//      vertical : 세로 방향
//      horizontal (생략): 가로 방향
// weight : 배치되는 뷰의 크기 비율

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
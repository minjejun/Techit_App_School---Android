package kr.co.lion.android05_framelayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

// FrameLayout
// 배치되는 뷰들이 좌측 상단에 붙어서 겹쳐져서 배치되는 뷰.
// 탭이나 자유로운 배치 등을 목적으로 사용.
// 현재는 다른 뷰들을 더 많이 사용하는 상황.

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
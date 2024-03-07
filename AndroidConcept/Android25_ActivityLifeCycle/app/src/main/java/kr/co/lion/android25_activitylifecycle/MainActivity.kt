package kr.co.lion.android25_activitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    // Activity가 처음 실행될 때
    // 화면 전환이 발생했을 때
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // 화면이 회전했을 때,
        // 액티비티가 가로인지 세로인지 판별.

        Log.d("test1234", "onCreate")
    }

    // onStart
    // Activity 동작이 시작될 때
    override fun onStart() {
        super.onStart()
        Log.d("test1234", "onStart")
    }

    // onResume
    // Activity 동작이 다시 시작될 때
    // Pause 상태에서 다시 Running 상태가 되기 전
    override fun onResume() {
        super.onResume()
        Log.d("test1234", "onResume")
    }

    // onRestart
    // Stop 상태에서 Start 상태가 되기 전에 호출됨.
    override fun onRestart() {
        super.onRestart()
        Log.d("test1234", "onRestart")
    }

    // onPause
    // Running 상태에서 일시 정지가 될 때
    override fun onPause() {
        super.onPause()
        Log.d("test1234", "onPause")
    }

    // onStop
    // Running 상태에서 정지가 될 때
    override fun onStop() {
        super.onStop()
        Log.d("test1234", "onStop")
    }

    // onDestroy
    // Activity가 종료될 때
    override fun onDestroy() {
        super.onDestroy()
        Log.d("test1234", "onDestroy")
    }
}
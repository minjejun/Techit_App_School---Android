package kr.co.lion.android11_material3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

// Material : 구글에서 만들어 배포하고 있는 UI 라이브러리
// Android, Flutter, Figma  등등에서 사용할 수 있도록 배포중.
// 현재 3 버전까지 나왔음.
// https://m3.material.io

// Material 3 라이브러리를 이용하고 싶다면 build.gradle.kts(Module) 파일에
// 라이브러리를 세팅해줘야 함.

// 최신 버전은 다음 페이지에서 확인함
// https://github.com/material-components/material-components-android/releases

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
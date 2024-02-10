package kr.co.lion.android06_constraintlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

// ConstraintLayout
// ConstraintLayout에 배치되는 뷰들은 부모 or 다른 뷰들과의 관계를 나타내는
// 제약 조건을 설정하여 뷰들을 배치.

// 제약 조건은 선으로 표시됨
// 직선 : 절대적 길이. 물리적인 액정 사이즈에 관계없이 고정된 길이 -> 무조건 띄우겠다는 의미.
// 지그재그선 : 상대적 길이. 물리적인 액정 사이즈에 따라 변화되는 길이. 비율.

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
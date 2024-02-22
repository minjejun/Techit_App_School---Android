package kr.co.lion.android16_radio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.lion.android16_radio.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        activityMainBinding.apply {

            // 두 번째 그룹의 라디오 버튼을 선택해줌.
            // 라디오 버튼 선택은 그룹을 통하지 않고 원하는 라디오 버튼에 직접 설정해줌.
            radioButton5.isChecked = true

            // 라디오 그룹의 리스너
            // 그룹 내의 체크 상태가 변경되었을 때
            // 두 번째 : 체크된 라디오 버튼의 ID
            Group1.setOnCheckedChangeListener { group, checkedId ->
                textView.text = when(checkedId) {
                    R.id.radioButton -> "첫 번째 라디오 버튼 선택"
                    R.id.radioButton2 -> "두 번째 라디오 버튼 선택"
                    R.id.radioButton3 -> "세 번째 라디오 버튼 선택"
                    else -> ""
                }
            }

            button.setOnClickListener {
                // 그룹 내에서 체크되어 있는 라디오 버튼 id 가져옴
                textView.text = when(Group2.checkedRadioButtonId) {
                    R.id.radioButton4 -> "네 번째 라디오 버튼 선택"
                    R.id.radioButton5 -> "다섯 번째 라디오 버튼 선택"
                    R.id.radioButton6 -> "여섯 번째 라디오 버튼 선택"
                    else -> ""
                    // 프로퍼티의 값만 집어넣었기에 else가 무조건 들어가 있어야 함.
                }
            }
        }
    }
}
package kr.co.lion.android12_materialbutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.lion.android12_materialbutton.databinding.ActivityMainBinding

// MaterialButton
// 그냥 버튼을 사용하면 android.widget.Button 클래스.
// Material Button을 사용하면 com.google.android.material.button 클래스.
// Material 3 라이브러리를 적용해주면 그냥 Button을 사용해도 Material Button 처럼 사용할 수 있음.
// 이는 Material Button과 Button이 크게 다르지 않고 다양한 테마를 제공하는 형태로 되어 있기 때문.

class MainActivity : AppCompatActivity() {

    lateinit var activityMainbinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainbinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainbinding.root)

        activityMainbinding.apply {
            button.setOnClickListener {
                textView.text = "Material 버튼을 눌렀습니다"
            }

            button2.setOnClickListener {
                textView.text = "Basic 버튼을 눌렀습니다"
            }

            // MaterialButtonToggleGroup 의 버튼을 선택해준다.
            toggleGroup1.check(R.id.toggleButton1)
            toggleGroup1.check(R.id.toggleButton3)

            toggleGroup1.check(R.id.toggleButton2)
            // 선택 취소
            toggleGroup1.uncheck(R.id.toggleButton2)

            // singleSelection에 true가 설정되어 있는 그룹의 버튼을 선택해줌.
            toggleGroup2.check(R.id.toggleButton4)
            toggleGroup2.check(R.id.toggleButton5)

            // 첫 번째 : 그룹 내부의 버튼의 체크 상태가 변경되었을 때
            // 두 번째 : 체크 상태가 변경된 버튼의 id
            // 세 번째 : 체크 되었는지 여부 (true / false)
            toggleGroup1.addOnButtonCheckedListener { group, checkId, isChekced ->
                // 버튼의 id로 분기
                when (checkId) {
                    R.id.toggleButton1 -> {
                        if (isChekced) {
                            textView.text = "토글 버튼 1이 체크되었습니다.\n"
                        } else {
                            textView.text = "토글 버튼 1이 체크 해제되었습니다.\n"
                        }
                    }
                    R.id.toggleButton2 -> {
                        if(isChekced) {
                            textView.text = "토글 버튼 2이 체크되었습니다.\n"
                        } else {
                            textView.text = "토글 버튼 2이 체크 해제되었습니다.\n"
                        }
                    }
                    R.id.toggleButton3 -> {
                        if(isChekced) {
                            textView.text = "토글 버튼 3이 체크되었습니다.\n"
                        } else {
                            textView.text = "토글 버튼 3이 체크 해제되었습니다.\n"
                        }
                    }
                }
            }
            // singleSelection
            toggleGroup2.addOnButtonCheckedListener { group, checkId, isChekced ->
                // 버튼의 id로 분기
                when (checkId) {
                    R.id.toggleButton4 -> {
                        if (isChekced) {
                            textView.text = "토글 버튼 4이 체크되었습니다.\n"
                        }
                    }
                    R.id.toggleButton5 -> {
                        if(isChekced) {
                            textView.text = "토글 버튼 5이 체크되었습니다.\n"
                        }
                    }
                    R.id.toggleButton6 -> {
                        if(isChekced) {
                            textView.text = "토글 버튼 6이 체크되었습니다.\n"
                        }
                    }
                }
            }

            buttonResult.setOnClickListener {
                // toggle1에서 체크되어 있는 버튼들의 아이디를 모두 가져옴
                toggleGroup1.checkedButtonIds.forEach {
                    when (it) {
                        R.id.toggleButton1 -> textView.append("토글1이 체크되어 있습니다.\n")
                        R.id.toggleButton2 -> textView.append("토글2가 체크되어 있습니다.\n")
                        R.id.toggleButton3 -> textView.append("토글3이 체크되어 있습니다.\n")
                    }
                }

                // toggle2에서 체크되어 있는 버튼의 아이디를 가져옴
                // SingleSelection이기 때문에 한개만 가져옴.
                when(toggleGroup2.checkedButtonId) {
                    R.id.toggleButton4 -> textView.append("토글4가 체크되어 있습니다.\n")
                    R.id.toggleButton5 -> textView.append("토글5가 체크되어 있습니다.\n")
                    R.id.toggleButton6 -> textView.append("토글6이 체크되어 있습니다.\n")
                }
            }
        }
    }
}